
package com.testjackson.googleimage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "moreResultsUrl",
    "currentPageIndex",
    "resultCount",
    "pages",
    "searchResultTime",
    "estimatedResultCount"
})
public class Cursor {

    @JsonProperty("moreResultsUrl")
    private String moreResultsUrl;
    @JsonProperty("currentPageIndex")
    private Integer currentPageIndex;
    @JsonProperty("resultCount")
    private String resultCount;
    @JsonProperty("pages")
    private List<Page> pages = new ArrayList<Page>();
    @JsonProperty("searchResultTime")
    private String searchResultTime;
    @JsonProperty("estimatedResultCount")
    private String estimatedResultCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The moreResultsUrl
     */
    @JsonProperty("moreResultsUrl")
    public String getMoreResultsUrl() {
        return moreResultsUrl;
    }

    /**
     * 
     * @param moreResultsUrl
     *     The moreResultsUrl
     */
    @JsonProperty("moreResultsUrl")
    public void setMoreResultsUrl(String moreResultsUrl) {
        this.moreResultsUrl = moreResultsUrl;
    }

    /**
     * 
     * @return
     *     The currentPageIndex
     */
    @JsonProperty("currentPageIndex")
    public Integer getCurrentPageIndex() {
        return currentPageIndex;
    }

    /**
     * 
     * @param currentPageIndex
     *     The currentPageIndex
     */
    @JsonProperty("currentPageIndex")
    public void setCurrentPageIndex(Integer currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    /**
     * 
     * @return
     *     The resultCount
     */
    @JsonProperty("resultCount")
    public String getResultCount() {
        return resultCount;
    }

    /**
     * 
     * @param resultCount
     *     The resultCount
     */
    @JsonProperty("resultCount")
    public void setResultCount(String resultCount) {
        this.resultCount = resultCount;
    }

    /**
     * 
     * @return
     *     The pages
     */
    @JsonProperty("pages")
    public List<Page> getPages() {
        return pages;
    }

    /**
     * 
     * @param pages
     *     The pages
     */
    @JsonProperty("pages")
    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    /**
     * 
     * @return
     *     The searchResultTime
     */
    @JsonProperty("searchResultTime")
    public String getSearchResultTime() {
        return searchResultTime;
    }

    /**
     * 
     * @param searchResultTime
     *     The searchResultTime
     */
    @JsonProperty("searchResultTime")
    public void setSearchResultTime(String searchResultTime) {
        this.searchResultTime = searchResultTime;
    }

    /**
     * 
     * @return
     *     The estimatedResultCount
     */
    @JsonProperty("estimatedResultCount")
    public String getEstimatedResultCount() {
        return estimatedResultCount;
    }

    /**
     * 
     * @param estimatedResultCount
     *     The estimatedResultCount
     */
    @JsonProperty("estimatedResultCount")
    public void setEstimatedResultCount(String estimatedResultCount) {
        this.estimatedResultCount = estimatedResultCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
