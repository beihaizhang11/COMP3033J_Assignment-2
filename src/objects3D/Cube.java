package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Cube {
	// Method to draw a Cube using OpenGL
	public void DrawCube() {
		// Define the vertices of the Cube
		Point4f vertices[] = { new Point4f(-1.0f, 1.0f, 1.0f, 1.0f), new Point4f(1.0f, 1.0f, 1.0f, 1.0f),
				new Point4f(1.0f, -1.0f, 1.0f, 1.0f), new Point4f(-1.0f, -1.0f, 1.0f, 1.0f),
				new Point4f(-1.0f, 1.0f, -1.0f, 1.0f), new Point4f(1.0f, 1.0f, -1.0f, 1.0f),
				new Point4f(1.0f, -1.0f, -1.0f, 1.0f), new Point4f(-1.0f, -1.0f, -1.0f, 1.0f) };

		// Define the faces of the Cube, each face is represented by 4 vertices
		int[][] faces = { { 0, 1, 2, 3 }, { 4, 5, 6, 7 }, { 4, 5, 1, 0 }, { 3, 2, 6, 7 }, { 1, 5, 6, 2 }, { 4, 0, 3, 7 } };

		// Start drawing quads for each face of the Cube
		GL11.glBegin(GL11.GL_QUADS);
		for (int face = 0; face < 6; face++) { // Loop through each face
			// Calculate the normal for the current face
			Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
			Vector4f w = vertices[faces[face][2]].MinusPoint(vertices[faces[face][0]]);
			Vector4f normal = v.cross(w).Normal();

			// Set the normal for the face
			GL11.glNormal3f(normal.x, normal.y, normal.z);

			// Draw each vertex of the face
			for (int vertex = 0; vertex < 4; vertex++) {
				Vector4f tempVector = new Vector4f(vertices[faces[face][vertex]].x, vertices[faces[face][vertex]].y, vertices[faces[face][vertex]].z, 1.0f);
				GL11.glVertex3f(tempVector.x, tempVector.y, tempVector.z);
			}
		} // End loop through each face
		GL11.glEnd(); // End drawing
	}
}
	 