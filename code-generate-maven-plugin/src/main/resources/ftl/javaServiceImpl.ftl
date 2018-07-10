<#include "stringUtil.ftl"/>
<#assign auth=(config['auth'])!/>
<@strExist source=config['provider.package'] trueVal='package '/>${(config['provider.package'])!}<@strExist source=config['provider.package'] trueVal=';'/>

<#if (config['model.package'])?? && ((config['model.package'])?length gt 0)>
import ${(config['model.package'])!}.${beanName!};
</#if>
<#if (config['dao.package'])?? && ((config['dao.package'])?length gt 0)>
import ${(config['dao.package'])!}.${beanName!}DAO;
</#if>
<#if (config['service.package'])?? && ((config['service.package'])?length gt 0)>
import ${(config['service.package'])!}.I${beanName!}Service;
</#if>
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 * ${tableRemark!} 服务实现类
 * </p>
 *
 * @author ${auth!}
 * @date ${(date?string("yyyy-MM-dd HH:mm:ss"))!}
 */
@Service
public class ${beanName!}ServiceImpl extends ServiceImpl<${beanName!}DAO, ${beanName!}> implements I${beanName!}Service {

}
