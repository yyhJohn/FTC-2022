package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;


@Autonomous(name = "Blueside_Left_Auto")


public class AutoBluesideLeft extends LinearOpMode {
    Hardwaremap autohwp = new Hardwaremap();
    EncoderDrive eg =new EncoderDrive();


    static final double DRIVE_SPEED = 1000;

    @Override
    public void runOpMode() throws InterruptedException {
        autohwp.init(hardwareMap);



        autohwp.Leftfront.setDirection(DcMotorSimple.Direction.REVERSE);
        autohwp.Rightfront.setDirection(DcMotorSimple.Direction.REVERSE);
        autohwp.Leftback.setDirection(DcMotorSimple.Direction.FORWARD);
        autohwp.Rightback.setDirection(DcMotorSimple.Direction.FORWARD);





        eg.encoderDrive(DRIVE_SPEED,0,0,0,0,0);

    }
}
