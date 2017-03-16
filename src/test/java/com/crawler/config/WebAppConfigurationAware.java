package com.crawler.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        ApplicationConfig.class
})
public abstract class WebAppConfigurationAware {

    @Inject
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;
    private MockRestServiceServer mockServer;

    @Autowired
    private RestTemplate template;

    @Before
    public void before() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        this.mockServer = MockRestServiceServer.bindTo(template).build();
    }

    @Test
    public void test() {
        assertTrue(true);
    }
}
