package objects3D;


import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Octahedron {
	// Method to draw an Octahedron using OpenGL
	public void DrawOctahedron() {
		// Define the vertices of the Octahedron
		Point4f vertices[] = { new Point4f(1, 0, 0, 1.0f), new Point4f(-1, 0, 0, 1.0f), new Point4f(0, 1, 0, 1.0f),
				new Point4f(0, -1, 0, 1.0f), new Point4f(0, 0, 1, 1.0f), new Point4f(0, 0, -1, 1.0f) };

		// Define the faces of the Octahedron, each face is represented by 3 vertices
		int[][] faces = { { 0, 2, 4 }, { 0, 4, 3 }, { 0, 3, 5 }, { 0, 5, 2 }, { 1, 4, 2 }, { 1, 3, 4 }, { 1, 5, 3 },
				{ 1, 2, 5 } };

		// Start drawing triangles for each face of the Octahedron
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
