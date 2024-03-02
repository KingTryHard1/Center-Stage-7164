package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class BlueClose {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(900);

        Pose2d startPose = new Pose2d(10, 61, Math.toRadians(-90));

        RoadRunnerBotEntity Left = new DefaultBotBuilder(meepMeep)
                // We set this bot to be blue
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(50, 50, Math.toRadians(180), Math.toRadians(180), 18)
                .build();

        RoadRunnerBotEntity Middle = new DefaultBotBuilder(meepMeep)
                // We set this bot to be blue
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(50, 50, Math.toRadians(180), Math.toRadians(180), 18)
                .build();

        RoadRunnerBotEntity Right = new DefaultBotBuilder(meepMeep)
                // We set this bot to be blue
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(50, 50, Math.toRadians(180), Math.toRadians(180), 18)
                .build();

        Left.runAction(Left.getDrive().actionBuilder(startPose)
                .setTangent(Math.toRadians(60))
                .splineToSplineHeading(new Pose2d(10, 29, Math.toRadians(-180)), Math.PI / 2)
                .setTangent(Math.toRadians(0))
                .splineToConstantHeading(new Vector2d(38, 33), Math.toRadians(0))
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(-8, 9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, 40), Math.toRadians(-90))
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(-8, 9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, 40), Math.toRadians(-90))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(61,10), Math.toRadians(0))
                .build());

        Middle.runAction(Middle.getDrive().actionBuilder(startPose)
                .setTangent(Math.toRadians(0))
                .lineToX(20)
                .setTangent(Math.toRadians(40))
                .splineToConstantHeading(new Vector2d(13, 33), Math.toRadians(0))
                .lineToXSplineHeading(38, Math.toRadians(180))
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(-8, 9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, 40), Math.toRadians(-90))
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(-8, 9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, 40), Math.toRadians(-90))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(61,10), Math.toRadians(0))
                .build());

        Right.runAction(Right.getDrive().actionBuilder(startPose)
                .setTangent(Math.toRadians(50))
                .splineToLinearHeading(new Pose2d(13, 32, Math.toRadians(0)), Math.toRadians(90))
                .setTangent(Math.toRadians(-90))
                .splineToSplineHeading(new Pose2d(25,48, Math.toRadians(-90)), Math.toRadians(0))
                .setTangent(Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(38, 40, Math.toRadians(-180)), Math.toRadians(90))
                .setTangent(Math.toRadians(45))
                .splineToConstantHeading(new Vector2d(-8, 9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, 30), Math.toRadians(-90))
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(-8, 9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, 30), Math.toRadians(-90))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(61,10), Math.toRadians(0))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(Right)
                .addEntity(Left)
                .addEntity(Middle)
                .start();
    }
}
