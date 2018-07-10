<#include "stringUtil.ftl"/>
<#assign auth=(config['auth'])!/>
<#assign notNullStr=(config['model.notNull'])!/>
<@strExist source=config['model.package'] trueVal='package '/>${(config['model.package'])!}<@strExist source=config['model.package'] trueVal=';'/>

import java.io.Serializable;
<#list importTypeList as item>
import ${item!};
</#list>
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * ${tableRemark!}
 * </p>
 *
 * @author ${auth!}
 * @date ${(date?string("yyyy-MM-dd HH:mm:ss"))!}
 */
@TableName("${tableName!}")
public class ${beanName!} implements Serializable {

    private static final long serialVersionUID = 1L;

<#list propertyList as item>
    /**
     * ${item.remark!}<#if item.notNull>${notNullStr!}</#if>
     */
    <#if item.primaryKey>@TableId(value = "${item.columnName!}", type = IdType.AUTO)<#else>@TableField("${item.columnName!}")</#if>
    private ${item.typeName!} ${item.propertyName!};

</#list>
<#list propertyList as item>
    public ${item.typeName!} ${item.getMethodName!}() {
        return ${item.propertyName!};
    }

    public void ${item.setMethodName!}(${item.typeName!} ${item.propertyName!}) {
        this.${item.propertyName!} = ${item.propertyName!};
    }

</#list>
}