package com.wxkoiok.fileupdown.service.impl;

import com.wxkoiok.fileupdown.service.SolrService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

/**
 * @description: solr服务
 * @author: wuxiang
 * @create: 2019-06-06 10:32
 **/
public class SolrServiceImpl implements SolrService {

    public static void main(String[] args) throws IOException, SolrServerException {
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder("http://localhost:8983/solr/mysql_core").build();
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("time_zone:东8区");
        QueryResponse query = httpSolrClient.query(solrQuery);
        SolrDocumentList results = query.getResults();
        SolrDocument entries = results.get(1);
        long numFound = results.getNumFound();
        System.out.println(numFound);

    }
}
