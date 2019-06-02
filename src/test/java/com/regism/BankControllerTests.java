package com.regism;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//import com.regism.config.WebSecurityConfig;
import com.regism.config.WebSecurityConfig;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebSecurityConfig.class)
public class BankControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    //@Autowired
    //private Filter springSecurityFilterChain;

    @Mock
    private FilterChainProxy springSecurityFilterChain;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        //MockitoAnnotations.initMocks(this);
        this.mockMvc = webAppContextSetup(this.webApplicationContext)
                //.apply(SecurityMockMvcConfigurers.springSecurity(springSecurityFilterChain))
                .alwaysExpect(status().isOk())
                .build();
    }

   /* @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(bankController)
                .apply(SecurityMockMvcConfigurers.springSecurity(springSecurityFilterChain))
                .build();
    }*/

    /*@Before
    public void setUp() throws Exception {
        final MockHttpServletRequestBuilder defaultRequestBuilder = get("/bank/transactions");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .defaultRequest(defaultRequestBuilder)
                .alwaysDo(result -> setSessionBackOnRequestBuilder(defaultRequestBuilder, result.getRequest()))
                .apply(springSecurity(springSecurityFilterChain))
                .build();
    }

    private MockHttpServletRequest setSessionBackOnRequestBuilder(final MockHttpServletRequestBuilder requestBuilder,
                                                                  final MockHttpServletRequest request) {
        requestBuilder.session((MockHttpSession) request.getSession());
        return request;
    }

    public void performLogin(final String username, final String password) throws Exception {
        final ResultActions resultActions = this.mockMvc.perform(formLogin().user(username).password(password));
        this.assertSuccessLogin(resultActions);
    }

    private void assertSuccessLogin(final ResultActions resultActions) throws Exception {
        resultActions.andExpect(status().isFound())
                .andExpect(authenticated())
                .andExpect(redirectedUrl("/"));
    }*/

//    @Autowired
//    private WebApplicationContext wac;

    //private RestManager restManager;

//    private RestManagerImpl restManager;

    /*@Mock
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;

    @Spy
    @InjectMocks
    private BankController controller = new BankController();

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }*/

//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }

    /*@Before
    public void setUp() {
        RestGatewaySupport gateway = new RestGatewaySupport();
        gateway.setRestTemplate(restTemplate);
        mockServer = MockRestServiceServer.createServer(gateway);
    }*/

/*    @Before
    public void setUp() {
        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
    }*/

/*    @Test
    public void getAllTransactions() throws Exception {
        this.mockMvc.perform(get("/transactions")
                .header("host", "localhost:8080"))
                .andDo(print())
                .andExpect(status().isOk());
    }*/

    @Test
    public void getAllTransactionsSuccess() throws Exception {
//        Project project = new Project();
//        project.setName("MyName");
//        String json = new Gson().toJson(project);
        //String result = "Hello";

        /*mockMvc.perform(get("http://localhost:8080/springMVC/bank/transactions2")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));*/

        this.mockMvc
                .perform(get("/transactions")
                //.with(httpBasic("admin","adminPass"))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]['id']").value("897706c1-dcc6-4e70-9d85-8a537c7cbf3e"))
                .andExpect(jsonPath("$[49]['id']").value("513f2868ca8ababf28c6b6c9"))
                .andExpect(jsonPath("$", hasSize(50)));
        //.andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        //.andExpect(content().string("Hello world!"));
    }

    /* @Test
    public void getAllTransactions2() {
        mockServer.expect(requestTo("/transactions2"))
            .andRespond(withSuccess("Hello", MediaType.TEXT_PLAIN));

        String result = "Hello";

        mockServer.verify();
        assertEquals("Hello", result);

        //List transactionsListTest = service.getExtRest();
        //System.out.println(transactionsListTest);

    }*/

   /* @Test
    public void getTrType() {
    }

    @Test
    public void getTATrType() {
    }*/
}