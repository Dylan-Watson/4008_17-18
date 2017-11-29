package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by BroncBotz on 10/17/2017.
 */
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name ="HardwareMap4008", group="")


public class TeleOp extends OpMode {

    HardwareMap4008 robot = new HardwareMap4008();

    @Override
    public void init(){
        robot.init(hardwareMap);
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


    }


    @Override
    public void stop(){}

}
