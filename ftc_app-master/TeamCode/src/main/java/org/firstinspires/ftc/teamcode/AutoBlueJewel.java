package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by BroncBotz on 12/6/2017.
 */
@Autonomous(name="Blue Auton Jewel", group="Jewel")
public class AutoBlueJewel extends LinearOpMode{

    HardwareMap4008 robot = new HardwareMap4008();
    private  ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode(){

        robot.init(hardwareMap);
        robot.initializeRobotPositions();
        waitForStart();
        runtime.reset();

        robot.lowerJewel();
        while(opModeIsActive() && runtime.seconds() < 1) {
            telemetry.addData("Blue:", robot.colorSensor.blue());
            telemetry.addLine("");
            telemetry.addData("Red: ", robot.colorSensor.red());
            telemetry.addData("Elapsed Time: ", runtime.seconds());
            telemetry.update();
        }



            if (robot.jewelRed())
                robot.setJewelBackPos();
            else
                robot.setJewelFrontPos();



     sleep(1000);
    }
}
