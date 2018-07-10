<#include "stringUtil.ftl"/>
<#assign daoPackage=config['dao.package']/>
<#assign modelPackage=config['model.package']/>
<#assign updateTime=(config['mapper.updateTime'])!/>
<#assign createTime=(config['mapper.createTime'])!/>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="<@daoFullName/>">

    <resultMap id="BaseResultMap" type="<@modelFullName/>">
        <@resultMap/>
    </resultMap>

    <resultMap id="BaseResultMapAS" type="<@modelFullName/>">
        <@resultMapAS prefix='${tableAlias!}'/>
    </resultMap>

    <sql id="Base_Column_List">
        <@colunmList/>
    </sql>

    <sql id="Base_Alias_Column_List">
        <@colunmList prefix='${tableAlias!}'/>
    </sql>

    <sql id="Base_Alias_Column_List_AS">
        <@colunmListAs prefix='${tableAlias!}'/>
    </sql>

</mapper>

<#macro daoFullName>
    <#t>${daoPackage!}<@strExist source=daoPackage trueVal='.'/>${beanName!}DAO
</#macro>
<#macro modelFullName>
    <#t>${modelPackage!}<@strExist source=daoPackage trueVal='.'/>${beanName!}
</#macro>

<#macro resultMap>
    <#list propertyList as item>
        <#if item.primaryKey??>
        <id column="${item.columnName!}" property="${item.propertyName!}" />
        <#else>
        <result column="${item.columnName!}" property="${item.propertyName!}" />
        </#if>
    </#list>
</#macro>
<#macro resultMapAS prefix=''>
    <#list propertyList as item>
        <#if item.primaryKey??>
        <id column="${prefix}<@strExist source=prefix trueVal='_'/>${item.columnName!}" property="${item.propertyName!}" />
        <#else>
        <result column="${prefix}<@strExist source=prefix trueVal='_'/>${item.columnName!}" property="${item.propertyName!}" />
        </#if>
    </#list>
</#macro>
<#macro colunmList prefix=''>
    <#list propertyList?chunk(10) as row>
        <#list row as item>${prefix}<@strExist source=prefix trueVal='.'/>${item.columnName!}<#if item_has_next || row_has_next>, </#if></#list>
    </#list>
</#macro>
<#macro colunmListAs prefix=''>
    <#list propertyList?chunk(10) as row>
        <#list row as item>${prefix}<@strExist source=prefix trueVal='.'/>${item.columnName!} AS ${prefix}<@strExist source=prefix trueVal='_'/>${item.columnName!}<#if item_has_next || row_has_next>, </#if></#list>
    </#list>
</#macro>
<#macro noIdColunmList>
    <#list propertyList?chunk(10) as row>
        <#if row_index=0>(</#if><#list row as item><#if !item.primaryKey??>${item.columnName!}<#if item_has_next || row_has_next>, </#if></#if></#list><#if !row_has_next>)</#if>
    </#list>
</#macro>
<#macro noIdColunmListValue prefix=''>
    <#list propertyList?chunk(10) as row>
        <#if prefix!=''>   </#if><#if row_index=0>(</#if><#list row as item><#if !item.primaryKey??><#if (updateTime?? && (updateTime?length gt 0) && (updateTime == item.columnName)) || (createTime?? && (createTime?length gt 0) && (createTime == item.columnName))>now()<#else>${'#'}{${prefix!}<@strExist source=prefix trueVal='.'/>${item.propertyName!}}</#if><#if item_has_next || row_has_next>, </#if></#if></#list><#if !row_has_next>)</#if>
    </#list>
</#macro>
<#macro idEqual>
    <#if primaryKeyColumnName?? && (primaryKeyColumnName?length > 0)>
        <#nt>${primaryKeyColumnName!} = ${'#'}{${primaryKeyPropertyName!}}<#t>
    </#if>
</#macro>