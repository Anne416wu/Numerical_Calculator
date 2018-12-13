package cn.wuqinxuan.view;

import cn.wuqinxuan.algorithm.Calculator;
import cn.wuqinxuan.algorithm.ExpressionIllegalException;
import cn.wuqinxuan.numbercruncher.program10_2.RegressionDemo;
import cn.wuqinxuan.numbercruncher.program13_3.PiBorweinDemo;
import cn.wuqinxuan.numbercruncher.program14_1.GenerateRandomNormalDemo;
import cn.wuqinxuan.numbercruncher.program14_2.GenerateRandomExponentialDemo;
import cn.wuqinxuan.numbercruncher.program14_3.BuffonDemo;
import cn.wuqinxuan.numbercruncher.program15_5.PrimePatternsDemo;
import cn.wuqinxuan.numbercruncher.program16_1.BifurcationDemo;
import cn.wuqinxuan.numbercruncher.program16_2.JuliaSetDemo;
import cn.wuqinxuan.numbercruncher.program16_3.NewtonsFractalDemo;
import cn.wuqinxuan.numbercruncher.program16_4.MandelbrotSetDemo;
import cn.wuqinxuan.numbercruncher.program3_1.FPFormatsDemo;
import cn.wuqinxuan.numbercruncher.program5_1.BisectionDemo;
import cn.wuqinxuan.numbercruncher.program5_2.RegulaFalsiDemo;
import cn.wuqinxuan.numbercruncher.program5_3.ImprovedRegulaFalsiDemo;
import cn.wuqinxuan.numbercruncher.program5_4.SecantDemo;
import cn.wuqinxuan.numbercruncher.program5_5.NewtonsDemo;
import cn.wuqinxuan.numbercruncher.program5_6.FixedPointDemo;
import cn.wuqinxuan.numbercruncher.program6_1.InterpolationDemo;
import cn.wuqinxuan.numbercruncher.program6_2.LinearRegressionDemo;
import cn.wuqinxuan.numbercruncher.program7_1.IntegrationDemo;
import cn.wuqinxuan.numbercruncher.program8_1.SolveDiffEqDemo;
import cn.wuqinxuan.numbercruncher.program9_1.TransformationDemo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wuqinxuan on 2018/11/19.
 */

public class FxCalcMainController {
    public static List<Map<String, String>> history = new ArrayList<>();

    public static int position = -2;

    private void fireHistoryChange(){
        fillData(LABEL3, LABEL4, history.size() - 1);
        fillData(LABEL1, LABEL2, history.size() - 2);
    }

    private void fillData(Label l1, Label l2, int index) {
        if (index >= 0 && index < history.size()){
            Map<String, String> map = history.get(index);
            String expression = map.get("expression");
            String result = map.get("result");
            l1.setText(expression);
            l2.setText(result);
        } else {
            l1.setText("");
            l2.setText("");
        }
    }
    @FXML
    private Label LABEL1;

    @FXML
    private Label LABEL2;

    @FXML
    private Label LABEL3;

    @FXML
    private Label LABEL4;

    @FXML
    private Label LABEL5;

    @FXML
    public void LABEL1_ONCLICK(MouseEvent event) {
        LABEL5.setText(LABEL5.getText() + LABEL1.getText());
    }

    @FXML
    public void LABEL2_ONCLICK(MouseEvent event) {
        LABEL5.setText(LABEL5.getText() + LABEL2.getText());
    }

    @FXML
    public void LABEL3_ONCLICK(MouseEvent event) {
        LABEL5.setText(LABEL5.getText() + LABEL3.getText());
    }

    @FXML
    public void LABEL4_ONCLICK(MouseEvent event) {
        LABEL5.setText(LABEL5.getText() + LABEL4.getText());
    }

    @FXML
    public void BUTTON_SIN_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "sin(");
    }

    @FXML
    public void BUTTON_COS_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "cos(");
    }

    @FXML
    public void BUTTON_TAN_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "tan(");
    }

    @FXML
    public void BUTTON_LEFT_PAREN_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "(");
    }

    @FXML
    public void BUTTON_RIGHT_PAREN_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + ")");
    }

    @FXML
    public void BUTTON_POWER_ONCLICK(ActionEvent event) {
        pressOperator();
        LABEL5.setText(LABEL5.getText() + "^");
    }

    @FXML
    public void BUTTON_FACTORIAL_ONCLICK(ActionEvent event) {
        pressOperator();
        LABEL5.setText(LABEL5.getText() + "!");
    }

    @FXML
    public void BUTTON_LOG_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "log(");
    }

    @FXML
    public void BUTTON_LN_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "ln(");
    }

    @FXML
    public void BUTTON_DIVIDE_ONCLICK(ActionEvent event) {
        pressOperator();
        LABEL5.setText(LABEL5.getText() + "/");
    }

    @FXML
    public void BUTTON_NEGATIVE_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "-");
    }

    @FXML
    public void BUTTON_PI_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "pi");
    }

    @FXML
    public void BUTTON_E_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "e");
    }

    @FXML
    public void BUTTON_MULTIPLY_ONCLICK(ActionEvent event) {
        pressOperator();
        LABEL5.setText(LABEL5.getText() + "*");
    }

    @FXML
    public void BUTTON_CLEAR_ALL_ONCLICK(ActionEvent event) {
        LABEL5.setText("");
        history.clear();
        fireHistoryChange();
        position = -2;
    }

    @FXML
    public void BUTTON_SQUARE_ONCLICK(ActionEvent event) {
        pressOperator();
        LABEL5.setText(LABEL5.getText() + "^2");
    }

    @FXML
    public void BUTTON_SQRT_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "sqrt(");
    }

    @FXML
    public void BUTTON_MINUS_ONCLICK(ActionEvent event) {
        pressOperator();
        LABEL5.setText(LABEL5.getText() + "-");
    }

    @FXML
    public void BUTTON_CLEAR_ONCLICK(ActionEvent event) {

        if (LABEL5.getText() != null && LABEL5.getText().length() > 0){
            LABEL5.setText("");
            return;
        }
        if (history.size() >= 1){
            history.remove(history.size() - 1);
            fireHistoryChange();
            position -= 1;
        }
    }

    @FXML
    public void BUTTON_EXPONENT_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "e^(");
    }

    @FXML
    public void BUTTON_RECIPROCAL_ONCLICK(ActionEvent event) {
        pressOperator();
        LABEL5.setText(LABEL5.getText() + "^-1");
    }

    @FXML
    public void BUTTON_POINT_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + ".");
    }

    @FXML
    public void BUTTON_EE_ONCLICK(ActionEvent event) {
        pressOperator();
        LABEL5.setText(LABEL5.getText() + "E");
    }

    @FXML
    public void BUTTON_ADD_ONCLICK(ActionEvent event) {
        pressOperator();
        LABEL5.setText(LABEL5.getText() + "+");
    }

    @FXML
    public void BUTTON_BACK_ONCLICK(ActionEvent event) {
        String s = LABEL5.getText();
        if(s != null && s.length() > 0){
            LABEL5.setText(s.substring(0, s.length()-1));
        }
    }

    @FXML
    public void BUTTON_EQUAL_ONCLICK(ActionEvent event) {

        if (LABEL5.getText().length() > 0) {
            try {
                String result = Calculator.calculate(LABEL5.getText());
                Map<String, String> map = new HashMap<>();
                map.put("expression", LABEL5.getText());
                map.put("result", result);
                history.add(map);
                fireHistoryChange();
                position += 1;
                LABEL5.setText("");
            } catch (ExpressionIllegalException e) {
                LABEL5.setText("expression illegal");
                System.out.println("expression illegal");
                // DO NOTHING
            }
        }

    }

    @FXML
    public void BUTTON0_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "0");
    }

    @FXML
    public void BUTTON1_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "1");
    }

    @FXML
    public void BUTTON2_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "2");
    }

    @FXML
    public void BUTTON3_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "3");
    }

    @FXML
    public void BUTTON4_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "4");
    }

    @FXML
    public void BUTTON5_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "5");
    }

    @FXML
    public void BUTTON6_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "6");
    }

    @FXML
    public void BUTTON7_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "7");
    }

    @FXML
    public void BUTTON8_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "8");
    }

    @FXML
    public void BUTTON9_ONCLICK(ActionEvent event) {
        LABEL5.setText(LABEL5.getText() + "9");
    }

    /**
     * 当LABEL5为空时输入必须有前置操作数的运算符时，将前置操作数设为ans
     */
    private void pressOperator() {

        if (LABEL5.getText() == null || LABEL5.getText().length() == 0) {
            if (history.size() > 0) {
                LABEL5.setText(history.get(history.size()-1).get("result"));
            }
        }
    }
    @FXML
    public void MenuItem_RegularFalsi_ONCLICK(ActionEvent event){
        RegulaFalsiDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Bisection_ONCLICK(ActionEvent event){
        BisectionDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Secant_ONCLICK(ActionEvent event){
        SecantDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Newtons_ONCLICK(ActionEvent event){
        NewtonsDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_ImprovedRegularFalsi_ONCLICK(ActionEvent event){
        ImprovedRegulaFalsiDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Fixedpoint_ONCLICK(ActionEvent event){
        FixedPointDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Interpolation_ONCLICK(ActionEvent event){
        InterpolationDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_LinearRegression_ONCLICK(ActionEvent event){
        LinearRegressionDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Integression_ONCLICK(ActionEvent event){
        IntegrationDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_SolveDiffEq_ONCLICK(ActionEvent event){
        SolveDiffEqDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Transformation_ONCLICK(ActionEvent event){
        TransformationDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_FPformats_ONCLICK(ActionEvent event){
        FPFormatsDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_LU_ONCLICK(ActionEvent event){
        RegressionDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_PI_ONCLICK(ActionEvent event){
        PiBorweinDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_GenerateRadomNormal_ONCLICK(ActionEvent event){
        GenerateRandomNormalDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_RandomExponential_ONCLICK(ActionEvent event){
        GenerateRandomExponentialDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Buffon_ONCLICK(ActionEvent event){
        BuffonDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_PrimePatterns_ONCLICK(ActionEvent event){
        PrimePatternsDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Bifurcation_ONCLICK(ActionEvent event){
        BifurcationDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Julia_ONCLICK(ActionEvent event){
        JuliaSetDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_NewtonsFractal_ONCLICK(ActionEvent event){
        NewtonsFractalDemo.main(new String[]{});
    }
    @FXML
    public void MenuItem_Mandelbrot_ONCLICK(ActionEvent event){
        MandelbrotSetDemo.main(new String[]{});
    }

}

