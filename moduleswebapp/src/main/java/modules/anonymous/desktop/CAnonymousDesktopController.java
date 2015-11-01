package modules.anonymous.desktop;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

public class CAnonymousDesktopController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 5053228681017194643L;

    Div divMainDesktop;

    @Wire
    Div divAnonymousDesktop;

    public void doAfterCompose( Component comp ) {

        try {

            super.doAfterCompose(comp);

            final Execution execution = Executions.getCurrent();

            divMainDesktop = (Div) execution.getArg().get("divMainDesktop");

        } catch ( Exception Ex ) {

            Ex.printStackTrace();

        }

    }

    @Listen("onClick=#btnLogin")
    public void onClickbtnLogin( Event event ) {

        Session currentSession = Sessions.getCurrent();

        currentSession.setAttribute("user", "logged");

        if ( divMainDesktop != null ) {

            divAnonymousDesktop.detach();

            Events.postEvent(new Event("onInitAuthenticatedDesktop", divMainDesktop));

        }

    }

}
