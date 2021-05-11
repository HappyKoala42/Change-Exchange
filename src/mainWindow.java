import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class mainWindow {

	protected Shell shell;
	private static Text txtCurrency;
	private static Text txtAmount;
	private static Text txtDimes;
	private static Text txtQuarters;
	private static Text txtNickels;
	private static Text txtPennies;
	private static Text txtLoonies;
	private static Text txtToonies;
    
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			mainWindow window = new mainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(408, 331);
		shell.setText("Change Exchange");
		
		txtCurrency = new Text(shell, SWT.BORDER);
		txtCurrency.setText("1");
		txtCurrency.setBounds(86, 72, 119, 21);
		
		Label lblCurrency = new Label(shell, SWT.NONE);
		lblCurrency.setBounds(25, 75, 55, 15);
		lblCurrency.setText("Currency");
		
		txtAmount = new Text(shell, SWT.BORDER);
		txtAmount.setText("0");
		txtAmount.setBounds(86, 160, 119, 21);
		
		Label lblAmount = new Label(shell, SWT.NONE);
		lblAmount.setBounds(25, 163, 55, 15);
		lblAmount.setText("Amount");
		
		Label lblQuarters = new Label(shell, SWT.NONE);
		lblQuarters.setBounds(25, 200, 55, 15);
		lblQuarters.setText("Quarters");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(25, 228, 55, 15);
		lblNewLabel.setText("Dimes");
		
		Label lblNickels = new Label(shell, SWT.NONE);
		lblNickels.setBounds(139, 200, 55, 15);
		lblNickels.setText("Nickels");
		
		Label lblPennies = new Label(shell, SWT.NONE);
		lblPennies.setBounds(139, 228, 55, 15);
		lblPennies.setText("Pennies");
		
		Label lblLoonies = new Label(shell, SWT.NONE);
		lblLoonies.setBounds(263, 200, 55, 15);
		lblLoonies.setText("Loonies");
		
		Label lblToonies = new Label(shell, SWT.NONE);
		lblToonies.setBounds(263, 228, 55, 15);
		lblToonies.setText("Toonies");
		
		txtDimes = new Text(shell, SWT.BORDER);
		txtDimes.setText("0");
		txtDimes.setBounds(86, 225, 41, 21);
		
		txtQuarters = new Text(shell, SWT.BORDER);
		txtQuarters.setText("0");
		txtQuarters.setBounds(86, 197, 41, 21);
		
		txtNickels = new Text(shell, SWT.BORDER);
		txtNickels.setText("0");
		txtNickels.setBounds(200, 197, 41, 21);
		
		txtPennies = new Text(shell, SWT.BORDER);
		txtPennies.setText("0");
		txtPennies.setBounds(200, 225, 41, 21);
		
		txtLoonies = new Text(shell, SWT.BORDER);
		txtLoonies.setText("0");
		txtLoonies.setBounds(324, 197, 41, 21);
		
		txtToonies = new Text(shell, SWT.BORDER);
		txtToonies.setText("0");
		txtToonies.setBounds(324, 225, 41, 21);
		
		Label lblAmountxxxx = new Label(shell, SWT.NONE);
		lblAmountxxxx.setBounds(96, 99, 94, 15);
		lblAmountxxxx.setText("Amount (xxxx.xx)");
		
		Button btnCalculate = new Button(shell, SWT.NONE);
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				String amount;
				int total, quarters, dimes, nickels, pennies, Loonies, Toonies;
			    double convertIn;
			    
				amount = txtCurrency.getText();
			
				// Convert the amount from $ to cents.
		        convertIn = Double.parseDouble(amount) * 100;
		        // Truncate all the decimals that come after cents.
		        total = (int)convertIn;

		        
		        // Calculate the number of Toonies
		        Toonies = total / 200;
		        total = total - (Toonies * 200);
		        // Calculate the number of Loonies
		        Loonies = total / 100;
		        total = total - (Loonies * 100);
		        // Calculate the number of quarters.
		        quarters = total / 25;
		        total = total - (quarters * 25);
		        // Calculate the number of dimes.
		        dimes = total/10;
		        total = total - (dimes *10);
		        // Calculate the number of nickels.
		        nickels = total/5;
		        total = total - (nickels * 5);
		        // Calculate the number of pennies.
		        pennies = total;
				
				// update output
		        txtAmount.setText(amount);
		        txtQuarters.setText(Integer.toString(quarters));
		        txtDimes.setText(Integer.toString(dimes));
		        txtNickels.setText(Integer.toString(nickels));
		        txtPennies.setText(Integer.toString(pennies));
		        txtLoonies.setText(Integer.toString(Loonies));
		        txtToonies.setText(Integer.toString(Toonies));
				
			}
		});
		btnCalculate.setBounds(211, 70, 75, 25);
		btnCalculate.setText("Calculate");
		
		Label lblChangeExchange = new Label(shell, SWT.NONE);
		lblChangeExchange.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		lblChangeExchange.setBounds(105, 23, 198, 32);
		lblChangeExchange.setText("Change Exchange");
		
		Button btnExit = new Button(shell, SWT.NONE);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				System.exit(0);
				
			}
		});
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnExit.setText("Exit");
		btnExit.setBounds(292, 70, 75, 25);

	}
}
