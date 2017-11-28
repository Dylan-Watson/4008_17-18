package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by BroncBotz on 10/17/2017.
 */
@TeleOp(name ="TeleOp", group="")


public class AndrewsTeleOp extends OpMode {

    AndrewBotHW robot = new AndrewBotHW();

    @Override
    public void init(){
        robot.init(hardwareMap);
        robot.initializeRobotPositions();
        robot.jewelManip.setPosition(jewelClosePos);
        robot.wheelL.setPosition(manipLeftClosed);
        robot.wheelL.setPosition(manipRightClosed);
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
            robot.wheelL.setPosition(manipLeftOpen);
            robot.wheelR.setPosition(manipRightOpen);
            robot.ILM.setPower(1);
            robot.IRM.setPower(1);
        }
        //outtake
        else if(gamepad2.a && !robot.touch.isPressed()){
            robot.wheelL.setPosition(manipLeftOpen);
            robot.wheelR.setPosition(manipRightOpen);
            robot.ILM.setPower(-1);
            robot.IRM.setPower(-1);
        }
        //glyph lift
        if(gamepad2.right_bumper){
            robot.wheelR.setPosition(manipRightClosed);
            robot.wheelL.setPosition(manipLeftClosed);
            robot.LRM.setPower(1);
            robot.LLM.setPower(1);
        }
        else if(gamepad2.left_bumper){
            robot.wheelL.setPosition(manipLeftOpen);
            robot.wheelR.setPosition(manipRightOpen);
            robot.LLM.setPower(-1);
            robot.LRM.setPower(-1);
        }
        //scoring
        else if(gamepad2.y){
            robot.wheelL.setPosition(manipLeftOpen);
            robot.wheelR.setPosition(manipRightOpen);
            robot.ILM.setPower(0);
            robot.IRM.setPower(0);
        }
        else{
            robot.wheelL.setPosition(manipLeftClosed);
            robot.wheelR.setPosition(manipRightClosed);
            robot.ILM.setPower(0);
            robot.IRM.setPower(0);
        }

    }


    @Override
    public void stop(){}

}
