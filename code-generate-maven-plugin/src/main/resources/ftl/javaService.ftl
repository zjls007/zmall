<#include "stringUtil.ftl"/>
<#assign auth=(config['auth'])!/>
<@strExist source=config['service.package'] trueVal='package '/>${(config['service.package'])!}<@strExist source=config['service.package'] trueVal=';'/>

<#if (config['model.package'])?? && ((config['model.package'])?length gt 0)>
import ${(config['model.package'])!}.${beanName!};
</#if>
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * ${tableRemark!} 服务类
 * </p>
 *
 * @author ${auth!}
 * @date ${(date?string("yyyy-MM-dd HH:mm:ss"))!}
 */
public interface I${beanName!}Service extends IService<${beanName!}> {

}
