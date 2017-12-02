package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by BroncBotz on 10/17/2017.
 */
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name ="Dec2Teleop", group="")


public class TeleOp extends OpMode {

    HardwareMap4008 robot = new HardwareMap4008();

    @Override
    public void init(){
        robot.init(hardwareMap);
    }



    @Override
    public void loop() {

        /** Driver Controls **/

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

       /** Operator Controls **/

       //x is intake

        //INTAKE ON GROUND
        if(gamepad2.x){
            //need to check that lift is down at some point before this
            robot.intakeGlyph();
        }
        else if(gamepad2.y){
            robot.outtakeGlyphOnGround();
        }
        else{
            robot.stopIntake();
        }

        //MOVE ARM
        if(gamepad2.left_bumper){
            robot.lowerArm();
        }
        else if(gamepad2.right_bumper){
            robot.raiseArm();
        }
        else{
            robot.stopArm();
        }

        if(gamepad2.a){
            robot.outtakeGlyphRaised();
        }
        else{
            robot.stopRaisedOuttake();
        }

        if(gamepad2.dpad_up){
            robot.grabberTilt2();
        }
        if(gamepad2.dpad_left||gamepad2.dpad_right)
        {
            robot.grabberTilt1();
        }
        if(gamepad2.dpad_down)
            robot.grabberHomePosition();


        if(gamepad2.left_stick_button)
            robot.gripGlyph();
        if(gamepad2.right_stick_button)
            robot.ungripGlyph();
 }


    @Override
    public void stop(){}

}
