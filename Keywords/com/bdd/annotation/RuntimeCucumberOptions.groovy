package com.bdd.annotation

import java.lang.annotation.Annotation

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberReporter

import cucumber.api.CucumberOptions
import cucumber.api.SnippetType
import internal.GlobalVariable

/*
 * Implementation based on Cucumber core 3.0.2
 */
public class RuntimeCucumberOptions implements CucumberOptions{
	private List<String> tags
	private List<String> features
	private List<String> plugin
	private List<String> glue
	private List<String> junit
	private List<String> name
	private boolean strict
	private boolean monochrome
	private boolean dryRun
	private SnippetType snippets

	public RuntimeCucumberOptions(
	List<String> features = [],
	List<String> tags = [],
	List<String> plugin = [],
	List<String> glue = [],
	boolean strict = false,
	boolean monochrome = false,
	boolean dryRun = false,
	List<String> junit = [],
	List<String> name = [],
	SnippetType snippets = SnippetType.UNDERSCORE
	) {
		this.features = features
		this.tags = tags
		this.plugin = plugin
		this.glue = glue
		this.strict = strict
		this.monochrome = monochrome
		this.dryRun = dryRun
		this.junit = junit
		this.name = name
		this.snippets = snippets
	}

	@Override
	public String[] junit() {
		return this.junit
	}

	@Override
	public String[] features() {
		return this.features
	}

	@Override
	public String[] plugin() {
		return this.plugin
	}

	@Override
	public String[] tags() {
		return this.tags
	}

	@Override
	public String[] name() {
		return this.name
	}

	@Override
	public String[] glue() {
		return this.glue
	}

	@Override
	public SnippetType snippets() {
		return this.snippets
	}

	@Override
	public boolean strict() {
		return this.strict
	}

	@Override
	public boolean monochrome() {
		return this.monochrome
	}

	@Override
	public boolean dryRun() {
		return this.dryRun
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		return RuntimeCucumberOptions.class;
	}
}
