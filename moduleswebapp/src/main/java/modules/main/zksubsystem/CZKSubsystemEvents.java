package modules.main.zksubsystem;

import java.util.List;

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
    public void cleanup( Execution execution, Execution arg1, List<Throwable> arg2 ) throws Exception {

    }

    @Override
    public void init( Execution execution, Execution arg1 ) throws Exception {

    }

    @Override
    public void cleanup( Desktop desktop ) throws Exception {

    }

    @Override
    public void init( Desktop desktop, Object arg1 ) throws Exception {

    }

    @Override
    public void cleanup( Session session ) throws Exception {

    }

    @Override
    public void init( Session session, Object arg1 ) throws Exception {

    }

    @Override
    public void cleanup( WebApp webapp ) throws Exception {

    }

    @Override
    public void init( WebApp webapp ) throws Exception {

    }

}
