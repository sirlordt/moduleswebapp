package modules.main;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.ClientInfoEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

public class CMainDesktopController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 5599146275756392901L;

    protected boolean bIsMobile = false;

    @Wire
    Div divMainDesktop;

    public void doAfterCompose( Component comp ) {

        try {

            super.doAfterCompose(comp);

            Session currentSession = Sessions.getCurrent();

            if ( currentSession.getAttribute("user") == null ) {

                Events.echoEvent(new Event("onInitAnonymousDesktop", divMainDesktop, null));

            } else {

                Events.echoEvent(new Event("onInitAuthenticatedDesktop", divMainDesktop, null));

            }

        } catch ( Exception Ex ) {

            Ex.printStackTrace();

        }

    }

    @Listen("onClientInfo=#divMainDesktop")
    public void onClientInfo( ClientInfoEvent event ) {

        bIsMobile = Executions.getCurrent().getBrowser("mobile") != null;

        // tm.setValue(evt.getTimeZone().toString());
        // scrn.setValue(evt.getScreenWidth()+"x"+evt.getScreenHeight()+"x"+evt.getColorDepth());

    }

    @Listen("onInitAnonymousDesktop=#divMainDesktop")
    public void onInitAnonymousDesktop( Event event ) {

        Map<String, Object> arg = new HashMap<String, Object>();

        arg.put("divMainDesktop", divMainDesktop);

        Component[] comps = Executions.getCurrent().createComponents("/WEB-INF/modules/anonymous.desktop.zul", arg);

        comps[0].setParent(divMainDesktop);

    }

    @Listen("onInitAuthenticatedDesktop=#divMainDesktop")
    public void onInitAuthenticatedDesktop( Event event ) {

        Map<String, Object> arg = new HashMap<String, Object>();

        arg.put("divMainDesktop", divMainDesktop);

        Component[] comps = Executions.getCurrent().createComponents("/WEB-INF/modules/authenticated.desktop.zul", arg);

        comps[0].setParent(divMainDesktop);

    }

}
