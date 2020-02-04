package com.bdd.annotation

import java.lang.annotation.Annotation
import java.lang.reflect.Field
import java.lang.reflect.Method

import cucumber.api.CucumberOptions
import cucumber.api.SnippetType

public class CucumberOptionsOverrider {
	private  List<String> features
	private  List<String> tags
	private  List<String> plugin
	private  List<String> glue
	private  List<String> junit
	private  List<String> name
	private  boolean strict
	private  boolean monochrome
	private  boolean dryRun
	private  SnippetType snippets

	private CucumberOptions currentOptions
	private Class runnerClass

	public CucumberOptionsOverrider(Class runnerClass) {
		this.runnerClass = runnerClass
		this.currentOptions = runnerClass.getAnnotation(CucumberOptions.class)
		this.features = this.currentOptions.features()
		this.tags = this.currentOptions.tags()
		this.plugin = this.currentOptions.plugin()
		this.glue = this.currentOptions.glue()
		this.strict = this.currentOptions.glue()
		this.monochrome = this.currentOptions.monochrome()
		this.dryRun = this.currentOptions.dryRun()
		this.junit = this.currentOptions.junit()
		this.name = this.currentOptions.name()
		this.snippets = this.currentOptions.snippets()
	}


	public CucumberOptionsOverrider features(List<String> features) {
		this.features = features
		return this
	}

	public CucumberOptionsOverrider tags(List<String> tags) {
		this.tags = tags
		return this
	}

	public CucumberOptionsOverrider plugin(List<String> plugin) {
		this.plugin = plugin
		return this
	}

	public CucumberOptionsOverrider glue(List<String> glue) {
		this.glue = glue
		return this
	}

	public CucumberOptionsOverrider junit(List<String> junit) {
		this.junit = junit
		return this
	}

	public CucumberOptionsOverrider name(List<String> name) {
		this.name = name
		return this
	}

	public void override() {
		this.strict = this.currentOptions.strict()
		this.monochrome = this.currentOptions.monochrome()
		this.dryRun = this.currentOptions.dryRun()
		this.snippets = this.currentOptions.snippets()
		Annotation newAnnotation = new RuntimeCucumberOptions(
				this.features,
				this.tags,
				this.plugin,
				this.glue,
				this.strict,
				this.monochrome,
				this.dryRun,
				this.junit,
				this.name,
				this.snippets
				)
		this.overrideAnnotation(runnerClass, newAnnotation)
	}

	private void overrideAnnotation(Class runnerClass, Annotation newAnnotation) {
		Method method = Class.class.getDeclaredMethod("annotationData", null);
		method.setAccessible(true);
		Object annotationData = method.invoke(runnerClass);
		Field annotations = annotationData.getClass().getDeclaredField("annotations");
		annotations.setAccessible(true);
		Map<Class<? extends Annotation>, Annotation> map =
				(Map<Class<? extends Annotation>, Annotation>) annotations.get(annotationData);
		map.put(CucumberOptions.class, newAnnotation)
	}
}
