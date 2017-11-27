package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by BroncBotz on 10/17/2017.
 */
@TeleOp(name ="andrewbot", group="")

public class AndrewsTeleOp extends OpMode {

    AndrewBotHW robot = new AndrewBotHW();
    double jewelClosePos = 0.1;
    double manipRightClosed = 0.2;
    double manipLeftClosed = 0.2;
    double manipRightOpen = 0.2;
    double manipLeftOpen = 0.2;


    @Override
    public void init(){
        robot.init(hardwareMap);
        robot.jewelManipulator.setPosition(jewelClosePos);
        robot.manipLeft.setPosition(manipLeftClosed);
        robot.manipLeft.setPosition(manipRightClosed);
    }



    @Override
    public void loop() {


        double r = Math.hypot(-gamepad1.left_stick_x, gamepad1.left_stick_y);
        double robotangle = Math.atan2(gamepad1.left_stick_y, -gamepad1.left_stick_x) -Math.PI / 4;
        double rightX = -gamepad1.right_stick_x;
        final double v1 = r * Math.cos(robotangle) + rightX;
        final double v2 = r * Math.sin(robotangle) - rightX;
        final double v3 = r * Math.sin(robotangle) + rightX;
        final double v4 = r * Math.cos(robotangle) - rightX;

        robot.FLM.setPower(v1);
        robot.FRM.setPower(v2);
        robot.BLM.setPower(v3);
        robot.BRM.setPower(v4);

        //intake
        if(gamepad2.x){
            robot.manipLeft.setPosition(manipLeftOpen);
            robot.manipRight.setPosition(manipRightOpen);
            robot.ILM.setPower(1);
            robot.IRM.setPower(1);
        }
        //outtake
        else if(gamepad2.a && !robot.touch.isPressed()){
            robot.manipLeft.setPosition(manipLeftOpen);
            robot.manipRight.setPosition(manipRightOpen);
            robot.ILM.setPower(-1);
            robot.IRM.setPower(-1);
        }
        //glyph lift
        if(gamepad2.right_bumper){
            robot.manipRight.setPosition(manipRightClosed);
            robot.manipLeft.setPosition(manipLeftClosed);
            robot.RGLM.setPower(1);
            robot.LGLM.setPower(1);
        }
        else if(gamepad2.left_bumper){
            robot.manipLeft.setPosition(manipLeftOpen);
            robot.manipRight.setPosition(manipRightOpen);
            robot.LGLM.setPower(-1);
            robot.RGLM.setPower(-1);
        }
        //scoring
        else if(gamepad2.y){
            robot.manipLeft.setPosition(manipLeftOpen);
            robot.manipRight.setPosition(manipRightOpen);
            robot.ILM.setPower(0);
            robot.IRM.setPower(0);
        }
        else{
            robot.manipLeft.setPosition(manipLeftClosed);
            robot.manipRight.setPosition(manipRightClosed);
            robot.ILM.setPower(0);
            robot.IRM.setPower(0);
        }

    }


    @Override
    public void stop(){}

}
