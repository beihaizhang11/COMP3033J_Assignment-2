package objects3D;

import org.lwjgl.opengl.GL11;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Icosahedron {
	// Method to draw an Icosahedron using OpenGL
	public void DrawIcosahedron() {
		float t = (float) ((1.0 + Math.sqrt(5.0)) / 2.0);

		// Define the vertices of the Icosahedron
		Point4f vertices[] = { new Point4f(-1, t, 0, 1.0f), new Point4f(1, t, 0, 1.0f), new Point4f(-1, -t, 0, 1.0f),
				new Point4f(1, -t, 0, 1.0f), new Point4f(0, -1, t, 1.0f), new Point4f(0, 1, t, 1.0f),
				new Point4f(0, -1, -t, 1.0f), new Point4f(0, 1, -t, 1.0f), new Point4f(t, 0, -1, 1.0f),
				new Point4f(t, 0, 1, 1.0f), new Point4f(-t, 0, -1, 1.0f), new Point4f(-t, 0, 1, 1.0f) };

		// Define the faces of the Icosahedron, each face is represented by 3 vertices
		int[][] faces = { { 0, 11, 5 }, { 0, 5, 1 }, { 0, 1, 7 }, { 0, 7, 10 }, { 0, 10, 11 }, { 1, 5, 9 }, { 5, 11, 4 },
				{ 11, 10, 2 }, { 10, 7, 6 }, { 7, 1, 8 }, { 3, 9, 4 }, { 3, 4, 2 }, { 3, 2, 6 }, { 3, 6, 8 }, { 3, 8, 9 },
				{ 4, 9, 5 }, { 2, 4, 11 }, { 6, 2, 10 }, { 8, 6, 7 }, { 9, 8, 1 } };

		// Start drawing triangles for each face of the Icosahedron
		GL11.glBegin(GL11.GL_TRIANGLES);
		for (int face = 0; face < faces.length; face++) { // Loop through each face
			// Calculate the normal for the current face
			Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
			Vector4f w = vertices[faces[face][2]].MinusPoint(vertices[faces[face][0]]);
			Vector4f normal = v.cross(w).Normal();

			// Set the normal for the face
			GL11.glNormal3f(normal.x, normal.y, normal.z);

			// Draw each vertex of the face
			for (int vertex = 0; vertex < 3; vertex++) {
				Vector4f tempVector = new Vector4f(vertices[faces[face][vertex]].x, vertices[faces[face][vertex]].y, vertices[faces[face][vertex]].z, 1.0f);
				GL11.glVertex3f(tempVector.x, tempVector.y, tempVector.z);
			}
		} // End loop through each face
		GL11.glEnd(); // End drawing
	}
}