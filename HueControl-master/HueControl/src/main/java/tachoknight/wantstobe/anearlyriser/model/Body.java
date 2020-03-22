package tachoknight.wantstobe.anearlyriser.model;

import org.codehaus.jackson.annotate.JsonProperty;
import java.util.*;

public class Body
{
	@JsonProperty("bri")
	private Integer			bri;
	@JsonProperty("transitiontime")
	private Integer			transitiontime;
	@JsonProperty("on")
	private Boolean			on;
	@JsonProperty("xy")
	private List<Double>	xy;

	public Integer getBri()
	{
		return bri;
	}

	public void setBri(Integer bri)
	{
		this.bri = bri;
	}

	public Integer getTransitiontime()
	{
		return transitiontime;
	}

	public void setTransitiontime(Integer transitiontime)
	{
		this.transitiontime = transitiontime;
	}

	public Boolean getOn()
	{
		return on;
	}

	public void setOn(Boolean on)
	{
		this.on = on;
	}

	public List<Double> getXy()
	{
		return xy;
	}

	public void setXy(List<Double> xy)
	{
		this.xy = xy;
	}

}
