package com.lcaohoanq.fxsnakegame.views;

import com.lcaohoanq.fxsnakegame.controllers.SwingLoginController;
import com.lcaohoanq.fxsnakegame.constants.ResourcePaths;
import com.lcaohoanq.fxsnakegame.controllers.ForgotPasswordController;
import com.lcaohoanq.fxsnakegame.controllers.PlayController;
import com.lcaohoanq.fxsnakegame.controllers.ToggleHandler;
import com.lcaohoanq.fxsnakegame.views.utils.UIPrompts;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lombok.Getter;
import com.lcaohoanq.fxsnakegame.models.LoginModel;
import com.lcaohoanq.fxsnakegame.dtos.UserDTO;
import com.lcaohoanq.fxsnakegame.styles.UIColors;
import com.lcaohoanq.fxsnakegame.styles.UIFonts;
import com.lcaohoanq.fxsnakegame.styles.UILabels;
import com.lcaohoanq.fxsnakegame.styles.UISizes;
import com.lcaohoanq.fxsnakegame.views.base.MyFrame;

@Deprecated
@Getter
public class SwingLoginView extends MyFrame implements ToggleHandler{

    private CardLayout cardLayout;
    private final LoginModel loginModel;
    private SwingLoginController loginController;
    private OTPVerificationView otpVerificationView;

    public SwingLoginView() {
        super();
        this.loginModel = new LoginModel();
        InputStream inputStream = getClass().getResourceAsStream(ResourcePaths.URL_INTRO);
        audioUtils.playAudio(inputStream);
        // Initialize OTPVerificationView
    }

    @Override
    public void initRight() {
        initRightTop();
        initRightMiddle();
        initRightBottom();
        initRightPanel();
    }

    @Override
    public void initRightTop() {
        jLabel_Right_Top_Title = new JLabel(UILabels.LOGIN, JLabel.CENTER);
        jLabel_Right_Top_Title.setForeground(UIColors.TEXT_COLOR_L);
        jLabel_Right_Top_Title.setFont(UIFonts.RIGHT_TITLE);
        jPanel_Right_Top_Title.add(jLabel_Right_Top_Title);
    }

    @Override
    public void initRightMiddle() {
        jPanel_Right_Middle_Data = new JPanel(new GridLayout(3, 1));

        cardLayout = new CardLayout();

        jTextField_Right_Middle_Email.setFont(UIFonts.INPUT_LARGE);

        jPasswordField_Right_Middle_Password.setFont(UIFonts.INPUT_LARGE);

        jPanel_Right_Middle_Email.add(jLabel_Right_Middle_Email);
        jPanel_Right_Middle_Email.add(jTextField_Right_Middle_Email);

        jPanel_Right_Middle_Password.add(jLabel_Right_Middle_Password);
        jPanel_Right_Middle_Password.add(jPasswordField_Right_Middle_Password);

        jButton_Right_Play.setBackground(UIColors.TEXT_COLOR_L);
        jButton_Right_Play.setForeground(UIColors.PRIMARY_COLOR_L);
        jButton_Right_Play.setFont(UIFonts.BUTTON);
        jButton_Right_Play.setPreferredSize(UISizes.SIZE_BUTTON);

        jButton_Right_Play.setCursor(cursor);

        jPanel_Right_Bottom_Button.setLayout(cardLayout);
        jPanel_Right_Bottom_Button.add(jButton_Right_Bottom_Submit, "Card1");
        jPanel_Right_Bottom_Button.add(jButton_Right_Play, "Card2");

        // Add jPanel_Right_Middle_Username and jPanel_Right_Middle_Password directly to
        // jPanel_Right

        jPanel_Right_Middle_Data.setBackground(UIColors.PRIMARY_COLOR_L);
        jPanel_Right_Middle_Data.add(jPanel_Right_Middle_Email);
        jPanel_Right_Middle_Data.add(jPanel_Right_Middle_Password);
        jPanel_Right_Middle_Data.add(jPanel_Right_Bottom_Button);
    }

    @Override
    public void initRightBottom() {
        jLabel_Right_Bottom_Option = new JLabel(UILabels.DONT_HAVE_ACCOUNT);
        jButton_Right_Bottom_Others = new JButton(UILabels.SIGN_UP_HERE);

        jButton_Right_Bottom_Forgot_Password.setBackground(UIColors.PRIMARY_COLOR_L);
        jButton_Right_Bottom_Forgot_Password.setForeground(UIColors.OTHER_OPTIONS_L);
        jButton_Right_Bottom_Forgot_Password.setFont(UIFonts.OTHERS);
        jButton_Right_Bottom_Forgot_Password.setBorder(null);

        jButton_Right_Bottom_Forgot_Password.setCursor(cursor);

        jLabel_Right_Bottom_Option.setForeground(UIColors.TEXT_COLOR_L);
        jLabel_Right_Bottom_Option.setFont(UIFonts.OTHERS);
        jPanel_Right_Bottom_Option.setBackground(UIColors.PRIMARY_COLOR_L);

        jButton_Right_Bottom_Others.setBackground(UIColors.PRIMARY_COLOR_L);
        jButton_Right_Bottom_Others.setForeground(UIColors.OTHER_OPTIONS_L);
        jButton_Right_Bottom_Others.setFont(UIFonts.OTHERS);
        jButton_Right_Bottom_Others.setBorder(null);
        jButton_Right_Bottom_Others.setCursor(cursor);

        jPanel_Right_Bottom_Option.add(jLabel_Right_Bottom_Option);
        jPanel_Right_Bottom_Option.add(jButton_Right_Bottom_Others);
        jPanel_Right_Bottom_Option.add(jButton_Right_Bottom_Forgot_Password);
    }

    @Override
    public void initRightPanel(){
        jPanel_Right.add(jPanel_Right_Top_Title, BorderLayout.NORTH);
        jPanel_Right.add(jPanel_Right_Middle_Data, BorderLayout.CENTER);
        jPanel_Right.add(jPanel_Right_Bottom_Option, BorderLayout.SOUTH);
    }

    @Override
    public void initToggle() {
        super.initToggle();
        toggleButton.addEventSelected(selected -> {
            if (selected) {
                jButton_Right_Play.setForeground(UIColors.PRIMARY_COLOR_D);
                jButton_Right_Play.setBackground(UIColors.TEXT_COLOR_D);
            } else {
                jButton_Right_Play.setBackground(UIColors.TEXT_COLOR_L);
                jButton_Right_Play.setForeground(UIColors.PRIMARY_COLOR_L);
            }
        });
    }

    @Override
    public void doAction() {
        // TODO Auto-generated method stub
        super.doAction();

        loginController = new SwingLoginController(this);

        jTextField_Right_Middle_Email.addMouseListener(loginController);
        jPasswordField_Right_Middle_Password.addMouseListener(loginController);
        jButton_Right_Bottom_Submit.addMouseListener(loginController);
        jButton_Right_Bottom_Others.addMouseListener(loginController);
        jButton_Right_Bottom_Submit.addActionListener(loginController);
        jButton_Right_Play.addActionListener(new PlayController(this));
        jPasswordField_Right_Middle_Password.addActionListener(new PressEnter());
        jButton_Right_Bottom_Others.addActionListener(new ClickOtherOption());
        jButton_Right_Bottom_Forgot_Password.addActionListener(new ForgotPasswordController(this, otpVerificationView));
        jButton_Right_Bottom_Forgot_Password.addMouseListener(loginController);
    }

    //xu li cac ham o day
    public UserDTO getDataWhenLogin() {
        return new UserDTO(jTextField_Right_Middle_Email.getText(), String.valueOf(jPasswordField_Right_Middle_Password.getPassword()));
    }

    public boolean isEmpty() {
        return this.loginModel.isEmpty(this.getDataWhenLogin().getEmail(), this.getDataWhenLogin().getPassword());
    }

    public boolean isAdmin() {
        return this.loginModel.isAdmin(this.getDataWhenLogin().getEmail(), this.getDataWhenLogin().getPassword());
    }

    public void handleSuccess() {
        UIPrompts.IS_LOGIN_SUCCESS();
        // Switch to the play button card
        this.getCardLayout().next(SwingLoginView.jPanel_Right_Bottom_Button);
        //hidden the username and password input field
        this.setStatusInputData(false);
    }

    //this method for test getLogin above
    public void setLogin(String username, String password) {
        jTextField_Right_Middle_Email.setText(username);
        jPasswordField_Right_Middle_Password.setText(password);
    }

    public void setStatusInputData(boolean status) {
        jTextField_Right_Middle_Email.setEnabled(status);
        jPasswordField_Right_Middle_Password.setEnabled(status);
    }

    @Override
    public void changeColorBaseOnToggle() {

    }

}
