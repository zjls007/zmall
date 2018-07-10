<#include "stringUtil.ftl"/>
<#assign auth=(config['auth'])!/>
<@strExist source=config['dao.package'] trueVal='package '/>${(config['dao.package'])!}<@strExist source=config['dao.package'] trueVal=';'/>

<#if (config['model.package'])?? && ((config['model.package'])?length gt 0)>
import ${(config['model.package'])!}.${beanName!};
</#if>
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * ${tableRemark!} DAO 接口
 * </p>
 *
 * @author ${auth!}
 * @date ${(date?string("yyyy-MM-dd HH:mm:ss"))!}
 */
public interface ${beanName!}DAO extends BaseMapper<${beanName!}> {

}
