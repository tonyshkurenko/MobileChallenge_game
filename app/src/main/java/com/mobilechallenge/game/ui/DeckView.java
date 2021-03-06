package com.mobilechallenge.game.ui;

import com.mobilechallenge.game.objects.Drawable;
import com.mobilechallenge.game.programs.SimpleVaryingColorShaderProgram;
import com.mobilechallenge.game.utils.VertexArray;

import static android.opengl.GLES20.GL_TRIANGLE_STRIP;
import static android.opengl.GLES20.glDrawArrays;
import static com.mobilechallenge.game.utils.Constants.BYTES_PER_FLOAT;

/**
 * Project: Game
 * Date: 10/18/15
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 */
public class DeckView implements Drawable {

  private static final int POSITION_COMPONENT_COUNT = 2;
  private static final int COLOR_COMPONENT_COUNT = 3;
  private static final int STRIDE =
      (POSITION_COMPONENT_COUNT + COLOR_COMPONENT_COUNT) * BYTES_PER_FLOAT;

  // @formatter:off
  private static final float[] VERTEX_DATA = {
      // Order of coordinates: X, Y, R, G, B
      // Triangle strip
      1f, 1f, 0.768627451f, 0.949019608f, 1f,
      -1f, 1f, 0.768627451f, 0.949019608f, 1f, // linear gradient from top to
      1f, -1f, 0.917647059f, 0.976470588f, 1f, // bottom
      -1f, -1f, 0.917647059f, 0.976470588f, 1f,
  };
  // @formatter:on

  private final VertexArray mVertexArray;

  public DeckView() {
    mVertexArray = new VertexArray(VERTEX_DATA);
  }

  public void bindData(SimpleVaryingColorShaderProgram shaderProgram) {
    mVertexArray.setVertexAttribPointer(0, shaderProgram.getPositionLocation(),
        POSITION_COMPONENT_COUNT, STRIDE);

    mVertexArray.setVertexAttribPointer(POSITION_COMPONENT_COUNT, shaderProgram.getColorLocation(),
        COLOR_COMPONENT_COUNT, STRIDE);
  }

  @Override public void draw() {
    glDrawArrays(GL_TRIANGLE_STRIP, 0, 4);
  }
}
