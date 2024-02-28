package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import javax.swing.border.MatteBorder;

public class RedClose {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(700);

        Pose2d startPose = new Pose2d(10, -61, Math.toRadians(90));

        RoadRunnerBotEntity Left = new DefaultBotBuilder(meepMeep)
                // We set this bot to be blue
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(40, 40, Math.toRadians(180), Math.toRadians(180), 18)
                .build();

        RoadRunnerBotEntity Middle = new DefaultBotBuilder(meepMeep)
                // We set this bot to be blue
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(40, 40, Math.toRadians(180), Math.toRadians(180), 18)
                .build();

        Left.runAction(Left.getDrive().actionBuilder(startPose)
                .setTangent(Math.toRadians(60))
                .splineToSplineHeading(new Pose2d(10, -29, Math.toRadians(180)), Math.PI / 2)
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(30, -33), Math.toRadians(0))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-8, -9), Math.toRadians(180))
                .setTangent(Math.toRadians(0))
                .splineToConstantHeading(new Vector2d(30, -40), Math.toRadians(-90))
                .setTangent(90)
                .splineToConstantHeading(new Vector2d(-8, -9), Math.toRadians(180))
                .setTangent(Math.toRadians(0))
                .splineToConstantHeading(new Vector2d(30, -40), Math.toRadians(-90))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(61,-10), Math.toRadians(9))
                .build());

        Middle.runAction(Middle.getDrive().actionBuilder(startPose)
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(13, -33), Math.PI / 2)
                .setTangent(Math.toRadians(0))
                .splineToConstantHeading(new Vector2d(30, -33), Math.toRadians(0))
                .turn(Math.toRadians(90))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-8, -9), Math.toRadians(180))
                .setTangent(Math.toRadians(0))
                .splineToConstantHeading(new Vector2d(30, -40), Math.toRadians(-90))
                .setTangent(90)
                .splineToConstantHeading(new Vector2d(-8, -9), Math.toRadians(180))
                .setTangent(Math.toRadians(0))
                .splineToConstantHeading(new Vector2d(30, -40), Math.toRadians(-90))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(61,-10), Math.toRadians(9))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(Middle)
                .start();
    }
}
