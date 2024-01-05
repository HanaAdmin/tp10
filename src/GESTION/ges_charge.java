package GESTION;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import connection.connection;

public class ges_charge extends JFrame implements ActionListener{
	
	private JTextField txttl,txtrec;
	private JLabel lbnump,lbnumc,lbtl;
	private JButton bten,ann,ter;
	private JComboBox cmbonump=new JComboBox();
	private JComboBox cmbonumc=new JComboBox();
	Statement st;
	private JButton lbrec;
	private String req1C = " select DISTINCT num_crs from  cours";
	private String req2E = " select DISTINCT num_prof from professeurs";
	
	
	connection k=new connection();
	
	public ges_charge()
	{ 
	   initCombo();
	  this.setTitle("Enregistrement_charge_prof_cours");
	  this.setSize(400,300);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     //JLabel lbpt=new JLabel("point :");
     JLabel lbnump=new JLabel("numero_prof:");
     JLabel lbnumc=new JLabel("Numero_cours");
     JLabel lbtl=new JLabel("Tel");
     
        txtrec=new JTextField();
       lbrec=new JButton("Rechercher");
        
        lbrec.setBounds(30, 5, 110, 20); p.add(lbrec); lbrec.addActionListener(this); 
        txtrec.setBounds(150,5,40,20);  p.add(txtrec); 
        
     
       
       txttl=new JTextField();
  
    
     
     
     bten=new JButton("Modifier");
     ann=new JButton("Supprimer"); 
     ter=new JButton("Terminer");   ter.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\fer.gif"));
     //bten.addActionListener(this);
     //ann.addActionListener(this);
     
     ann.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\supp.png"));
     //boutton
     Font fe=new Font("Serif",0,15);
     
     
     
     
     
     //ajouts dans le panel
    lbnump.setBounds(30,30,120,25); p.add(lbnump);
    cmbonump.setBounds(200,30,120,25); p.add(cmbonump);
    
    
     cmbonump.setForeground(Color.black); cmbonumc.setPreferredSize(new Dimension( 400 , 200));
     
      lbnumc.setBounds(30,70,120,25);  p.add(lbnumc);  lbnumc.setFont(fe);
      cmbonumc.setBounds(200,70,120,25);p.add(cmbonumc);
     
      lbtl.setBounds(30,110,120,25);  p.add(lbtl);  lbtl.setFont(fe);
      txttl.setBounds(200,110,120,25);p.add(txttl); txttl.setFont(fe);
     
		
     
     
     
     
     
    // txtrec.setBounds(180,150,110,20);p.add(txtrec);
 
     
     
     //ajout buttons
     
    bten.setBounds(50,160,120,27); p.add(bten); bten.setFont(fe); bten.setBackground(Color.CYAN); 	bten.addActionListener(this);
   ann.setBounds(200,160,130,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);     ann.addActionListener(this);
   ter.setBounds(50,210,130,27); p.add(ter);  ter.setFont(fe);  ter.setBackground(Color.CYAN);     ter.addActionListener(this);
    		
     /*supp.setBounds(180,80,110,20); p.add(supp);
     modif.setBounds(180,110,110,20); p.add(modif);
     rech.setBounds(30,150,110,20);  p.add(rech);*/
     //fer.setBounds(100,190,110,20); p.add(fer);*/
     
     //CONTENU DU PANEL
     
     add(p); 
     
     
     
     
       
		
		
	}
	
	
	//recherche de numero cours dans le combo
	private void initCombo(){
		 
		 
			 Statement state;ResultSet res;
			 connection kk=new connection();
			 
			try {
				state=kk.etablirconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
				state.executeQuery(req1C);
				
				res = state.getResultSet();
				while(res.next()){
					cmbonumc.addItem(res.getString("num_crs"));
					
				}res.close();state.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	
			try {
				state=kk.etablirconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
				state.executeQuery(req2E);
				
				res = state.getResultSet();
				while(res.next()){
					cmbonump.addItem(res.getString("num_prof"));
					
				}res.close();state.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
	//fermeture de la fenetre
			
			
}

/*
static public void main(String[] args) {
	
	ges_charge f=new ges_charge();
	f.setVisible(true);
	
}*/


@Override
public void actionPerformed(ActionEvent a) {
ResultSet rst1;

	    
	if(a.getSource()==bten)
	{
		String n,ppr,t;
	   String cc=(String) cmbonump.getSelectedItem();
	   String cc3=(String) cmbonumc.getSelectedItem();
       t=txttl.getText(); 
		
		String query="UPDATE  charge SET Tel="+t+"  Where num_prof="+cc+" and num_crs="+cc3+"";
		
		
		try {
			 st=k.etablirconnection().createStatement();
			 
			 if(JOptionPane.showConfirmDialog(this, "Voulez vraiment Modifiez ? ",null, JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
			 {
			    st.executeUpdate(query);
			    JOptionPane.showMessageDialog(this,"Modification effectuez avec succès");
			 } 
			 else if (JOptionPane.OK_CANCEL_OPTION==JOptionPane.NO_OPTION){ 
				}
		}
		 catch (SQLException e2) {
			   JOptionPane.showMessageDialog(null, "Erreur de Modification verifiez le lien ou n'existe pas");
	}}
	
	//terminer
	if(a.getSource()==ter)
	{
		
		if(JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		   {
			   dispose();
		   }
		
	}

	//suppression
	
	if(a.getSource()==ann)
	{
		String nm;
		nm=txtrec.getText(); 
		
	String req="DELETE FROM charge WHERE num_prof='"+nm+"'";
	
	try {
		
		 
		if(JOptionPane.showConfirmDialog(this, "Voulez vraiment supprimez ","", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		{  
			st.executeUpdate(req);
		
			
		    JOptionPane.showMessageDialog(this,"Suppression effectuez avec succès");
		}
		
		 
	} 

     catch (SQLException e3) {
		  System.out.println("ERREUR2");
	
		
		}
		
   	}
//rechercher
	
	if(a.getSource()==lbrec)
	{ String n;
		n=txtrec.getText(); 
		
String query="SELECT * FROM charge  WHERE num_prof='"+n+"'";
		
	try {
		st=	k.etablirconnection().createStatement();
		
		 rst1=st.executeQuery(query);
		
		if(rst1.next())
		{  cmbonump.setSelectedItem(rst1.getString("num_prof"));
			cmbonumc.setSelectedItem(rst1.getString("num_crs"));
			txttl.setText(rst1.getString("Tel"));
		
			
			
		} 
		else 
			JOptionPane.showMessageDialog(this,"INTROUVABLE","Erreur",JOptionPane.ERROR_MESSAGE);
	    } catch (SQLException e1)
	
	{
        
		}

	
	//modification du tel
	
	
	
	
	
	
	}}}








	 















