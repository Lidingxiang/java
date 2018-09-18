package org.mybatis.generator.plugins.field;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class FieldsPlugin extends PluginAdapter
{
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
	{

		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
	{
		ImportSwaggerAndHibValidate(topLevelClass, introspectedTable, true);
		addfields(topLevelClass, introspectedTable, "fields");

		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}

	private void ImportSwaggerAndHibValidate(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, boolean isExample)
	{
		if (!isExample)
		{
			FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType("io.swagger.annotations.ApiModelProperty");
			FullyQualifiedJavaType fullyQualifiedJavaType1 = new FullyQualifiedJavaType("io.swagger.annotations.ApiModel");
			topLevelClass.addImportedType(fullyQualifiedJavaType);
			topLevelClass.addImportedType(fullyQualifiedJavaType1);
			
			FullyQualifiedJavaType fullyQualifiedJavaType2 = new FullyQualifiedJavaType("org.hibernate.validator.constraints.NotBlank");
			FullyQualifiedJavaType fullyQualifiedJavaType3 = new FullyQualifiedJavaType(" cicada.web.valid.UpdateCheck");
			FullyQualifiedJavaType fullyQualifiedJavaType4 = new FullyQualifiedJavaType(" cicada.web.valid.InsertCheck");

			topLevelClass.addImportedType(fullyQualifiedJavaType2);
			topLevelClass.addImportedType(fullyQualifiedJavaType3);
			topLevelClass.addImportedType(fullyQualifiedJavaType4);
			String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
			topLevelClass.addAnnotation("@ApiModel(value =\"" + tableName + "\", description =\"" + tableName + "\" )");
		}
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
	{
		ImportSwaggerAndHibValidate(topLevelClass, introspectedTable, false);
		return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	}

	@Override
	public boolean sqlMapBaseColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
	{
		XmlElement isNullElement = new XmlElement("if"); //$NON-NLS-1$
		isNullElement.addAttribute(new Attribute("test", "fields == null")); //$NON-NLS-1$ //$NON-NLS-2$
		for (Element e : element.getElements())
		{
			isNullElement.addElement(e);
		}
		element.getElements().clear();
		element.addElement(isNullElement);

		XmlElement isNotNullElement = new XmlElement("if");
		isNotNullElement.addAttribute(new Attribute("test", "fields != null"));
		isNotNullElement.addElement(new TextElement("${fields}"));
		element.addElement(isNotNullElement);

		return super.sqlMapBaseColumnListElementGenerated(element, introspectedTable);
	}

	private void addfields(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name)
	{
		CommentGenerator commentGenerator = context.getCommentGenerator();
		Field field = new Field();
		field.setVisibility(JavaVisibility.PROTECTED);
		field.setType(PrimitiveTypeWrapper.getStringInstance());
		field.setName(name);
		commentGenerator.addFieldComment(field, introspectedTable);
		topLevelClass.addField(field);
		char c = name.charAt(0);
		String camel = Character.toUpperCase(c) + name.substring(1);
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + camel);
		method.addParameter(new Parameter(PrimitiveTypeWrapper.getStringInstance(), name));
		method.addBodyLine("this." + name + "=" + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(PrimitiveTypeWrapper.getStringInstance());
		method.setName("get" + camel);
		method.addBodyLine("return " + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
	}

	@Override
	public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
	{
		List<Element> elements = element.getElements();
		StringBuilder columns = new StringBuilder();
		List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();
		for (IntrospectedColumn introspectedColumn : allColumns)
		{
			columns.append(",").append(introspectedColumn.getActualColumnName());
		}
		columns.deleteCharAt(0);
		elements.set(1, new TextElement(columns.toString()));
		return super.sqlMapSelectByPrimaryKeyElementGenerated(element, introspectedTable);
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
	{
		ImportSwaggerAndHibValidate(topLevelClass, introspectedTable, false);
		return super.modelPrimaryKeyClassGenerated(topLevelClass, introspectedTable);
	}

	public boolean validate(List<String> warnings)
	{
		return true;
	}

}
