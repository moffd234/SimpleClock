import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SimpleClock extends JFrame implements ActionListener {
    
        Calendar calendar;
        SimpleDateFormat timeFormat;
        SimpleDateFormat dayFormat;
        SimpleDateFormat dateFormat;
        SimpleDateFormat tf12;
        SimpleDateFormat tf24;
    
        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        JButton formatButton;
        String time;
        String day;
        String date;

        SimpleClock() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setSize(400, 251);
            this.setResizable(false);

            tf12 = new SimpleDateFormat("hh:mm:ss a");
            tf24 = new SimpleDateFormat("HH:mm:ss a");
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            dayFormat=new SimpleDateFormat("EEEE");
            dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
            timeLabel.setBackground(Color.BLACK);
            timeLabel.setForeground(Color.WHITE);
            timeLabel.setOpaque(true);
            dayLabel=new JLabel();
            dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
    
            dateLabel=new JLabel();
            dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));

            formatButton = new JButton("Change time format");
            formatButton.setFont(new Font("Ink Free", Font.BOLD, 30));
            formatButton.addActionListener(this);
    
            this.add(timeLabel);
            this.add(dayLabel);
            this.add(dateLabel);
            this.add(formatButton);
            this.setVisible(true);
    
            setTimer();
        }
    
        public void setTimer() {
            while (true) {
                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);
    
                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day);
    
                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);
    
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
        public static void main(String[] args) {
            new SimpleClock();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == formatButton) {
            if(timeFormat == tf12) {
                timeFormat = tf24;
            }
            else{
                timeFormat = tf12;
            }
        }
    }
}
