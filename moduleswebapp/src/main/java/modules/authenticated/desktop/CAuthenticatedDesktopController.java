package modules.authenticated.desktop;

import java.util.HashMap;
import java.util.Map;

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
import org.zkoss.zul.Window;

public class CAuthenticatedDesktopController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 8724380367784871577L;

    Div divMainDesktop;

    @Wire
    Div divAuthenticatedDesktop;

    public void doAfterCompose( Component comp ) {

        try {

            super.doAfterCompose(comp);

            final Execution execution = Executions.getCurrent();

            divMainDesktop = (Div) execution.getArg().get("divMainDesktop");

        } catch ( Exception Ex ) {

            Ex.printStackTrace();

        }

    }

    @Listen("onClick=#btnLogout")
    public void onClickbtnLogin( Event event ) {

        Session currentSession = Sessions.getCurrent();

        currentSession.removeAttribute("user");

        // currentSession.invalidate();

        if ( divMainDesktop != null ) {

            divAuthenticatedDesktop.detach();

            Events.postEvent(new Event("onInitAnonymousDesktop", divMainDesktop));

        }

    }

    @Listen("onClick=#btnTestDialog")
    public void onClickbtnTestDialog( Event event ) {

        if ( divMainDesktop != null ) {

            try {

                Map<String, Object> arg = new HashMap<String, Object>();

                arg.put("divMainDesktop", divMainDesktop);
                arg.put("divAuthenticatedDesktop", divAuthenticatedDesktop);

                //Component[] comps = Executions.getCurrent().createComponents("~./modules/authenticated/dialogs/test/test.zul", arg);
                Component[] comps = Executions.getCurrent().createComponents("WEB-INF/classes/modules/authenticated/dialogs/test/test.zul", arg);

                comps[0].setParent(divMainDesktop);
                
                ((Window) comps[0] ).doModal();
                

            } catch ( Exception Ex ) {

                Ex.printStackTrace();

            }

        }

    }

}
