package modules.main.zksubsystem;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.DesktopCleanup;
import org.zkoss.zk.ui.util.DesktopInit;
import org.zkoss.zk.ui.util.ExecutionCleanup;
import org.zkoss.zk.ui.util.ExecutionInit;
import org.zkoss.zk.ui.util.SessionCleanup;
import org.zkoss.zk.ui.util.SessionInit;
import org.zkoss.zk.ui.util.WebAppCleanup;
import org.zkoss.zk.ui.util.WebAppInit;

public class CZKSubsystemEvents implements WebAppInit, WebAppCleanup, SessionInit, SessionCleanup, DesktopInit, DesktopCleanup, ExecutionInit, ExecutionCleanup {

    @Override
    public void init( WebApp webapp ) throws Exception {

        System.out.println( "WebApp init" );
        
    }

    @Override
    public void cleanup( WebApp webapp ) throws Exception {

        System.out.println( "WebApp cleanup" );
        
    }

    @Override
    public void init( Session session, Object request ) throws Exception {

        System.out.println( "Session init" );
        
    }

    @Override
    public void cleanup( Session session ) throws Exception {

        System.out.println( "Session cleanup" );
        
    }

    @Override
    public void init( Desktop desktop, Object request ) throws Exception {

        System.out.println( "Desktop init" );

    }

    @Override
    public void cleanup( Desktop desktop ) throws Exception {

        System.out.println( "Desktop cleanup" );
        
    }

    @Override
    public void init( Execution execution, Execution parent ) throws Exception {

        System.out.println( "Execution init" );
        
    }

    @Override
    public void cleanup( Execution execution, Execution parent, java.util.List<java.lang.Throwable> errs ) throws Exception {

        System.out.println( "Execution cleanup" );
        
    }

}
