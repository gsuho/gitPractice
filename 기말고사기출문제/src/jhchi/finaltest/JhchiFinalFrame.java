package jhchi.finaltest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class JhchiFinalFrame extends JFrame {
	SubjectManager manager;	
	Container c = getContentPane();
	JPanel northpanel;
	JTextArea ta;
	//라디오버튼 만들기
	JRadioButton asc,desc;
	boolean ascflag = true;
	
	//테이블 만들기
	String[] header = {"학번","이름"};
	DefaultTableModel model;
	JTable table;
	
	//c.setLayout(new BorderLayout()); //컨텐트페인 설정
	//레이아웃 종류: Flow, Border , Grid, Card
	
	public JhchiFinalFrame(String title, SubjectManager manager){
		super(title);
		this.manager = manager;		
		this.setSize(500,250);
		c.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //끄면 프로그램 종료
		init();
		this.setVisible(true);
	}

	public void init() {
		initNorth();
		initCenter();
	}

	private void initCenter() {
		// TODO Auto-generated method stub
		this.model = new DefaultTableModel(header, 0);
		this.table = new JTable(model);
		
		this.c.add(new JScrollPane(table), BorderLayout.CENTER);
		for (int i =0 ; i <manager.sublist.size();i++) {
		//model.addRow(toString(manager.findSubject(manager.sublist.get(i).subID)));
		}
	}

	private void initNorth() {
		// TODO Auto-generated method stub
		this.northpanel = new JPanel();
		String[] subid = new String[manager.sublist.size()];
		for(int i =0; i<manager.sublist.size(); i++) {
			subid[i]= manager.sublist.get(i).subID;
		}
		JComboBox combo= new JComboBox(subid);
		northpanel.add(combo);
		JLabel label = new JLabel("검색할 학번");
		northpanel.add(label);
		JTextField tf = new JTextField(10);
		
		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String search = tf.getText();
				List<Subject> format= manager.findStudent(search);
				if(format== null) {
					JOptionPane.showMessageDialog(JhchiFinalFrame.this, "학번을 확인해 주세요.");
					//메시지 출력코드
				}else {
					for(Subject sub : format) {
						System.out.println(sub);
						//table에 보여주기를 구현해야함.
					}
				}
			}
			
		});
		northpanel.add(tf);
		this.asc = new JRadioButton("asc",true);
		//라디오 버튼 -> 아이템이벤트 발생 -> 아이템 리스너
		this.asc.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {
					ascflag = true;
					//table에 보여주는 코드
				}
			}
			
		});
		this.desc = new JRadioButton("desc");
		this.desc.addItemListener(e->{
			if(e.getStateChange()==ItemEvent.SELECTED) {
				ascflag=false;
				//table에 보여주는 코드
			}
		});
		ButtonGroup g = new ButtonGroup(); 
		//라디오버튼을 묶어주는것 = 버튼 그룹
		g.add(asc);
		g.add(desc);
		
		northpanel.add(asc);
		northpanel.add(desc);
							
		
		c.add(northpanel, BorderLayout.NORTH);
	}
}
