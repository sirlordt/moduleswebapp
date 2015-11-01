package modules.authenticated.dialogs.test;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Window;

public class CTestController extends SelectorComposer<Component> {

    private static final long serialVersionUID = -1605874792576945794L;

    @Wire
    Window winTestDialog;

    Div divMainDesktop = null;

    Div divAuthenticatedDesktop = null;

    public void doAfterCompose( Component comp ) {

        try {

            super.doAfterCompose(comp);

            final Execution execution = Executions.getCurrent();

            divMainDesktop = (Div) execution.getArg().get("divMainDesktop");

            divAuthenticatedDesktop = (Div) execution.getArg().get("divAuthenticatedDesktop");

        } catch ( Exception Ex ) {

            Ex.printStackTrace();

        }

    }

}
