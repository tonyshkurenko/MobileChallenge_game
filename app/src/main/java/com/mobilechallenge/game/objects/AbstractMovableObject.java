package com.mobilechallenge.game.objects;

import com.mobilechallenge.game.utils.Geometry;
import java.util.Random;

/**
 * Project: Game
 * Date: 10/20/15
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 */
public abstract class AbstractMovableObject extends BaseObject implements Movable {

  protected Geometry.Point mPosition;
  protected Geometry.Vector mVector; // speed

  public AbstractMovableObject(Geometry.Point startPosition, Geometry.Vector startSpeedVector) {
    this(null, startPosition, startSpeedVector);
  }

  public AbstractMovableObject(Drawable image, Geometry.Point startPosition,
      Geometry.Vector startSpeedVector) {
    super(image);

    mPosition = startPosition;
    mVector = startSpeedVector;
  }

  @Override public void move() {
    mPosition = mPosition.translate(mVector);
  }

  @Override public Geometry.Point getInterpolatedPosition(float interpolation) {
    return mPosition.translate(mVector.scale(interpolation));
  }

  @Override public void stop() {
    mVector = new Geometry.Vector(0f, 0f, 0f);
  }

  public void setSpeed(Geometry.Vector newSpeed) {
    mVector = newSpeed;
  }

  public void scaleSpeed(float f) {
    mVector = mVector.scale(f);
  }

  public void accelerate(float add) {
    mVector = mVector.extend2d(add);
  }

  public void rotateRandom(Random r) {
    mVector = mVector.rotateRandom(r);
  }

  public void setPosition(Geometry.Point newPosition) {
    mPosition = newPosition;
  }

  public Geometry.Point getPosition() {
    return mPosition;
  }

  public Geometry.Vector getSpeed() {
    return mVector;
  }
}
