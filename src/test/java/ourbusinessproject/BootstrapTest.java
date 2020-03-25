package ourbusinessproject;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BootstrapTest {

    private Bootstrap bootstrap;

    @MockBean
    private InitializationService initializationService;

    @Before
    public void setUp() {
        bootstrap = new Bootstrap(initializationService);
    }

    @Test
    public void testInitMethodInvokeInitializationService() {
        assertThat(bootstrap, is(notNullValue()));
        bootstrap.init();
        verify(initializationService).initProjects();
    }

    @Test
    public void testIniBootstrapMethodCatchRuntimeExceptionComingFromInitProjects() {
        willThrow(RuntimeException.class).given(initializationService).initProjects();
        bootstrap.init();
    }

}
