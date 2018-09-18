package org.mybatis.generator.plugins.comment;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class MyCommentGenerator implements CommentGenerator
{

	@Override
	public void addConfigurationProperties(Properties properties)
	{
	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
	{
		String mark = introspectedColumn.getRemarks();
		field.addJavaDocLine("/**");
		field.addJavaDocLine(" * " + mark);
		field.addJavaDocLine(" */");
		// mark = mark.replaceAll("\"", "").replaceAll(" ", "");
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(mark);
		mark = m.replaceAll("").replaceAll("\"", "");
		boolean isRequied = introspectedColumn.isNullable();

		field.addAnnotation("@ApiModelProperty(value =\"" + mark + "\", required = " + !isRequied + ")");
		if (!isRequied)
		{

			String group = "";
			boolean isPrimaryKey = introspectedTable.getPrimaryKeyColumns().contains(introspectedColumn);
			if (isPrimaryKey && field.getName().trim().toLowerCase().equals("id"))
			{
				group = "{UpdateCheck.class}";
			}
			else
			{
				group = "{InsertCheck.class}";
			}
			String msg = String.format("字段%s不能为空", field.getName());
			String check = String.format("groups =%s", group);

			String filedType=field.getType().getFullyQualifiedName();
			
			if (filedType.equals("java.lang.String"))
			{
				String tip = "@NotBlank(message=\"" + msg + "\"," + check + ")";
				// field.addAnnotation("@NotBlank(message=\"" + msg + "\")");
				field.addAnnotation(tip);
			}
		}
	}

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable)
	{
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable)
	{
	}

	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete)
	{
	}

	@Override
	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable)
	{
	}

	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
	{
	}

	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
	{
	}

	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable)
	{
	}

	@Override
	public void addJavaFileComment(CompilationUnit compilationUnit)
	{
	}

	@Override
	public void addComment(XmlElement xmlElement)
	{
	}

	@Override
	public void addRootComment(XmlElement rootElement)
	{
	}

}
