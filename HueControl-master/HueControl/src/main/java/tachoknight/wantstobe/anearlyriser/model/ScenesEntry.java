package tachoknight.wantstobe.anearlyriser.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ScenesEntry
{
	@JsonProperty("name")
	private String			name;
	@JsonProperty("lights")
	private List<Integer>	lights;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Integer> getLights()
	{
		return lights;
	}

	public void setLights(List<Integer> lights)
	{
		this.lights = lights;
	}
}
