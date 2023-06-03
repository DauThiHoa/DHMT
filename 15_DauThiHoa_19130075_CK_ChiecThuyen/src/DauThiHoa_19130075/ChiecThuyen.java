package DauThiHoa_19130075;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Frame;

import jgl.GL;
import jgl.GLCanvas;
import jgl.GLU;
import jgl.GLUT;
import jgl.glu.GLUquadricObj;

public class ChiecThuyen extends GLCanvas {

	private static double zLookAt = 50.0;
	private static double xLookAt = 0.0;
	private static double yLookAt = 1.0;

	private static float rotatef = 220.0f;
	private static double rKinhKhiCau = 0.0f;
	private static float yKinhKhiCau = 2.0f;
	private static float rRua = 0.0f, xRua = -6.0f;
	private static float nuoc = 1.0f;
	private static double xRoBot = 0.5, yRoBot = -10.5;

	private static float x1 = 0.0f, y1 = 0.0f, z1 = 1.0f;
	private static float rDanCa = 0.0f, xDanCa = 1.0f, yDanCa = 0.0f, zDanCa = 0.0f;
	private static float rNocNha = 0.0f;
	private int startList;

	public void errorCallback(int errorCode) {
		String estring;

		estring = myGLU.gluErrorString(errorCode);
		System.err.println("Quadric Error: " + estring);
	}

	private static float yNuocBien = 5.5f; 

	private static final float ctrlpoints[][][] = {
			{ { -2.0f, 0.0f, 2.0f }, { -1.0f, 2.0f, 2.0f }, { 1.0f, 2.0f, 2.0f }, { 2.0f, 0.0f, 2.0f } },
			{ { -2.0f, 0.0f, 0.0f }, { -1.0f, 1.0f, 0.0f }, { 1.0f, 1.0f, 0.0f }, { 2.0f, 0.0f, 0.0f } },
			{ { -2.0f, 0.0f, 0.0f }, { -1.0f, -1.0f, 0.0f }, { 1.0f, -1.0f, 0.0f }, { 2.0f, 0.0f, 0.0f } },
			{ { -2.0f, 0.0f, 2.0f }, { -1.0f, -2.0f, 2.0f }, { 1.0f, -2.0f, 2.0f }, { 2.0f, 0.0f, 2.0f } } };

	private static final float texpts[][][] = { { { 0.0f, 0.0f }, { 0.0f, 1.0f } },
			{ { 1.0f, 0.0f }, { 1.0f, 1.0f } } };

	// -------------------------Ve khong gian
	// ---------------------------------------------//
	private static final int checkImageWidth = 500;
	private static final int checkImageHeight = 500;
	
	private byte imageCenter[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRight[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageLeft[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageTop[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBottom[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBefoter[][][] = new byte[checkImageWidth][checkImageHeight][4];

	//////////////////////////// TUP LEU ///////////////////////////////////////
	private byte imageCenterTupLeu[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRightTupLeu[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageLeftTupLeu[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageTopTupLeu[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBottomTupLeu[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBefoterTupLeu[][][] = new byte[checkImageWidth][checkImageHeight][4];

	///////////////////////////////////////////////////////////////////////////
	// NocNha
	private byte imageRightNocNha[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageLeftNocNha[][][] = new byte[checkImageWidth][checkImageHeight][4];

	private static int shoulderXC = 0, elbow = 0, shoulderXD = 0, shoulderCT = 90, shoulderCP = 90;
	private static int shoulderX = 248, shoulderTP = 0, shoulderTT = 0, elbowTT = 0, elbowTP = 0, elbowCT = 90,
			elbowCP = 90;
//	private static float x1 = 0.0f, y1 = 0.0f, z1 = 0.0f;
	private static float x11 = -1.0f, y11 = 0.0f, z11 = 0.0f;
	private static float x12 = -1.0f, y12 = 0.0f, z12 = 0.0f;
	private static float x2 = 1.0f, y2 = 1.0f, z2 = 0.6f;

	private static float ty = 0.0f, tx = 0.0f;
	private static float tqy = 0.5f, tqx = 0.0f;

	private static float tcx = 0.0f, tcy = 0.5f;
	private static float tqcx = 0.0f, tqcy = 0.1f;

	private static float tqttx = 0.0f, tqtty = -0.25f;
	private static float tqtpx = 0.0f, tqtpy = -0.25f;

	private static float tqctx = 0.0f, tqcty = -0.5f;
	private static float tqcpx = 0.0f, tqcpy = -0.5f;

	private static float ct = 0.0f;
	private static double xt = -1.5, yt = -0.2, zt = 1.2;

	private int texName[] = new int[14];

	private static float r = 0.0f;
	private static double t = 15.1, xkhonggian = 0.0;

	private static float xMayBay = 4.0f, zMayBay = -4.0f;
	private static double rMayBay = 324.0;
	private static float xTuyet = 3.0f, yTuyet = -8.0f, zTuyet = -14.0f;
	private static double rTuyet = 0.0;
	private static float xThuyen = 1.0f, yThuyen = 1.0f, zThuyen = 1.0f; 
	private static float xNuoc = 2.0f, yNuoc = 2.0f, zNuoc = 2.0f; 
	
	private void makeCheckImage() throws IOException {
		int i, j;
		float ti, tj;

		String str = "C:\\Users\\THINKPRO\\Pictures\\DHMT\\";

		File bmpCenterFile = new File(str + "centerChiecThuyen.bmp");
		File bmpRightFile = new File(str + "rightChiecThuyen.bmp");
		File bmpLeftFile = new File(str + "leftChiecThuyen.bmp");
		File bmpTopFile = new File(str + "topChiecThuyen.bmp");
		File bmpBottomFile = new File(str + "bottomChiecThuyen.bmp");
		File bmpBefoterFile = new File(str + "befoterChiecThuyen.bmp");

		BufferedImage iCenter = ImageIO.read(bmpCenterFile);
		BufferedImage iRight = ImageIO.read(bmpRightFile);
		BufferedImage iLeft = ImageIO.read(bmpLeftFile);
		BufferedImage iTop = ImageIO.read(bmpTopFile);
		BufferedImage iBottom = ImageIO.read(bmpBottomFile);
		BufferedImage iBefoter = ImageIO.read(bmpBefoterFile);

		File bmpCenterFileTupLeu = new File(str + "centerNhaChiecThuyen.bmp");
		File bmpRightFileTupLeu = new File(str + "leftNhaChiecThuyen.bmp");
		File bmpLeftFileTupLeu = new File(str + "leftNhaChiecThuyen.bmp");
		File bmpTopFileTupLeu = new File(str + "topCanPhong.bmp");
		File bmpBottomFileTupLeu = new File(str + "topCanPhong.bmp");
		File bmpBefoterFileTupLeu = new File(str + "chiecThuyen.bmp");

//		File bmpCenterFileTupLeu = new File(str + "centerCanPhong.bmp");
//		File bmpRightFileTupLeu = new File(str + "leftCanPhong.bmp");
//		File bmpLeftFileTupLeu = new File(str + "leftCanPhong.bmp");
//		File bmpTopFileTupLeu = new File(str + "topCanPhong.bmp");
//		File bmpBottomFileTupLeu = new File(str + "topCanPhong.bmp");
//		File bmpBefoterFileTupLeu = new File(str + "chiecThuyen.bmp");
		
		BufferedImage iCenterTupLeu = ImageIO.read(bmpCenterFileTupLeu);
		BufferedImage iRightTupLeu = ImageIO.read(bmpRightFileTupLeu);
		BufferedImage iLeftTupLeu = ImageIO.read(bmpLeftFileTupLeu);
		BufferedImage iTopTupLeu = ImageIO.read(bmpTopFileTupLeu);
		BufferedImage iBottomTupLeu = ImageIO.read(bmpBottomFileTupLeu);
		BufferedImage iBefoterTupLeu = ImageIO.read(bmpBefoterFileTupLeu);

		// ================NocNha=====================
		File bmpRightNocNha = new File(str + "nocNhaChiecThuyen.bmp");
		File bmpLeftNocNha = new File(str + "nocNhaChiecThuyen.bmp");
		
//		File bmpRightNocNha = new File(str + "nocNha.bmp");
//		File bmpLeftNocNha = new File(str + "nocNha.bmp");

		BufferedImage iRightNocNha = ImageIO.read(bmpRightNocNha);
		BufferedImage iLeftNocNha = ImageIO.read(bmpLeftNocNha);

		for (i = 0; i < checkImageWidth; i++) {
			for (j = 0; j < checkImageHeight; j++) {

				Color cCenter = new Color(iCenter.getRGB(i, j));
				Color cRight = new Color(iRight.getRGB(i, j));
				Color cLeft = new Color(iLeft.getRGB(i, j));
				Color cTop = new Color(iTop.getRGB(i, j));
				Color cBottom = new Color(iBottom.getRGB(i, j));
				Color cBefoter = new Color(iBefoter.getRGB(i, j));

				imageCenter[i][j][0] = (byte) (cCenter.getRed());
				imageCenter[i][j][1] = (byte) (cCenter.getGreen());
				imageCenter[i][j][2] = (byte) (cCenter.getBlue());
				imageCenter[i][j][3] = (byte) 225;

				imageRight[i][j][0] = (byte) (cRight.getRed());
				imageRight[i][j][1] = (byte) (cRight.getGreen());
				imageRight[i][j][2] = (byte) (cRight.getBlue());
				imageRight[i][j][3] = (byte) 225;

				imageLeft[i][j][0] = (byte) (cLeft.getRed());
				imageLeft[i][j][1] = (byte) (cLeft.getGreen());
				imageLeft[i][j][2] = (byte) (cLeft.getBlue());
				imageLeft[i][j][3] = (byte) 225;

				imageTop[i][j][0] = (byte) (cTop.getRed());
				imageTop[i][j][1] = (byte) (cTop.getGreen());
				imageTop[i][j][2] = (byte) (cTop.getBlue());
				imageTop[i][j][3] = (byte) 225;

				imageBottom[i][j][0] = (byte) (cBottom.getRed());
				imageBottom[i][j][1] = (byte) (cBottom.getGreen());
				imageBottom[i][j][2] = (byte) (cBottom.getBlue());
				imageBottom[i][j][3] = (byte) 225;

				imageBefoter[i][j][0] = (byte) (cBefoter.getRed());
				imageBefoter[i][j][1] = (byte) (cBefoter.getGreen());
				imageBefoter[i][j][2] = (byte) (cBefoter.getBlue());
				imageBefoter[i][j][3] = (byte) 225;

				Color cCenterTupLeu = new Color(iCenterTupLeu.getRGB(i, j));
				Color cRightTupLeu = new Color(iRightTupLeu.getRGB(i, j));
				Color cLeftTupLeu = new Color(iLeftTupLeu.getRGB(i, j));
				Color cTopTupLeu = new Color(iTopTupLeu.getRGB(i, j));
				Color cBottomTupLeu = new Color(iBottomTupLeu.getRGB(i, j));
				Color cBefoterTupLeu = new Color(iBefoterTupLeu.getRGB(i, j));

				imageCenterTupLeu[i][j][0] = (byte) (cCenterTupLeu.getRed());
				imageCenterTupLeu[i][j][1] = (byte) (cCenterTupLeu.getGreen());
				imageCenterTupLeu[i][j][2] = (byte) (cCenterTupLeu.getBlue());
				imageCenterTupLeu[i][j][3] = (byte) 225;

				imageRightTupLeu[i][j][0] = (byte) (cRightTupLeu.getRed());
				imageRightTupLeu[i][j][1] = (byte) (cRightTupLeu.getGreen());
				imageRightTupLeu[i][j][2] = (byte) (cRightTupLeu.getBlue());
				imageRightTupLeu[i][j][3] = (byte) 225;

				imageLeftTupLeu[i][j][0] = (byte) (cLeftTupLeu.getRed());
				imageLeftTupLeu[i][j][1] = (byte) (cLeftTupLeu.getGreen());
				imageLeftTupLeu[i][j][2] = (byte) (cLeftTupLeu.getBlue());
				imageLeftTupLeu[i][j][3] = (byte) 225;

				imageTopTupLeu[i][j][0] = (byte) (cTopTupLeu.getRed());
				imageTopTupLeu[i][j][1] = (byte) (cTopTupLeu.getGreen());
				imageTopTupLeu[i][j][2] = (byte) (cTopTupLeu.getBlue());
				imageTopTupLeu[i][j][3] = (byte) 225;

				imageBottomTupLeu[i][j][0] = (byte) (cBottomTupLeu.getRed());
				imageBottomTupLeu[i][j][1] = (byte) (cBottomTupLeu.getGreen());
				imageBottomTupLeu[i][j][2] = (byte) (cBottomTupLeu.getBlue());
				imageBottomTupLeu[i][j][3] = (byte) 225;

				imageBefoterTupLeu[i][j][0] = (byte) (cBefoterTupLeu.getRed());
				imageBefoterTupLeu[i][j][1] = (byte) (cBefoterTupLeu.getGreen());
				imageBefoterTupLeu[i][j][2] = (byte) (cBefoterTupLeu.getBlue());
				imageBefoterTupLeu[i][j][3] = (byte) 225;

				// ===================NocNha=======================================//

				Color cRightNocNha = new Color(iRightNocNha.getRGB(i, j));
				Color cLeftNocNha = new Color(iLeftNocNha.getRGB(i, j));

				imageRightNocNha[i][j][0] = (byte) (cRightNocNha.getRed());
				imageRightNocNha[i][j][1] = (byte) (cRightNocNha.getGreen());
				imageRightNocNha[i][j][2] = (byte) (cRightNocNha.getBlue());
				imageRightNocNha[i][j][3] = (byte) 225;

				imageLeftNocNha[i][j][0] = (byte) (cLeftNocNha.getRed());
				imageLeftNocNha[i][j][1] = (byte) (cLeftNocNha.getGreen());
				imageLeftNocNha[i][j][2] = (byte) (cLeftNocNha.getBlue());
				imageLeftNocNha[i][j][3] = (byte) 225;

			}
		}
	}
	// -----------------------------------------------------------------------//

	private static final int imageWidth = 500;
	private static final int imageHeght = 500;

	private byte image[][][] = new byte[imageHeght][imageWidth][3];
	private int shoulder;

	private void makeImage() {
		int i, j;
		float ti, tj;
		File bmpFile = new File("C:\\Users\\THINKPRO\\Pictures\\DHMT\\chiecThuyen.bmp");
		try {
			BufferedImage image1 = ImageIO.read(bmpFile);

			for (i = 0; i < imageWidth; i++) {
				for (j = 0; j < imageHeght; j++) {
					Color c = new Color(image1.getRGB(i, j));
					image[i][j][0] = (byte) (c.getRed());
					image[i][j][1] = (byte) (c.getGreen());
					image[i][j][2] = (byte) (c.getBlue());
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void myinit() throws IOException {

//    	 myGL.glPushMatrix(); 

		myGL.glMap2f(GL.GL_MAP2_VERTEX_3, 0.0f, 1.0f, 3, 4, 0.0f, 1.0f, 3, 4, ctrlpoints);
		myGL.glMap2f(GL.GL_MAP2_TEXTURE_COORD_2, 0.0f, 1.0f, 2, 2, 0.0f, 1.0f, 4, 2, texpts);
		myGL.glEnable(GL.GL_MAP2_TEXTURE_COORD_2);
		myGL.glEnable(GL.GL_MAP2_VERTEX_3);
		myGL.glMapGrid2f(20, 0.0f, 1.0f, 20, 0.0f, 1.0f);
		makeImage();
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);

		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, 3, imageWidth, imageHeght, 0, GL.GL_RGB, GL.GL_UNSIGNED_BYTE, image);

		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glEnable(GL.GL_DEPTH_TEST);
		myGL.glEnable(GL.GL_NORMALIZE);
		myGL.glEnable(GL.GL_SMOOTH);

//		myGL.glPopMatrix();

		myGL.glPushMatrix();
		makeCheckImage();

		myGL.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 1); // Dua ra -> Luu trong bo nho

		myGL.glGenTextures(14, texName);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[0]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageCenter); // value GL_UNSIGNED_BYTE -> Lay 8 bit checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[1]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRight);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[2]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeft); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[3]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageTop);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[4]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBottom);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBefoter);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageCenterTupLeu); // value GL_UNSIGNED_BYTE -> Lay 8 bit checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRightTupLeu);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeftTupLeu); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[9]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageTopTupLeu);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBottomTupLeu);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRightNocNha);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[12]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeftNocNha); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[13]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBefoterTupLeu);

		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();

		// --------------------------------------------------//

	}

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

		myGL.glMatrixMode(GL.GL_MODELVIEW);
		myGL.glLoadIdentity();
		myGLU.gluLookAt(xLookAt, yLookAt, zLookAt, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

		float mat_specular[] = { 0.5f, 0.5f, 0.0f, 0.0f }; // Mau Anh sang chieu
		float mat_shininess[] = { 0.0f }; // Muc do bao trum

		float boPhanMat_specular[] = { 0.0f, 0.0f, 0.0f, 1.0f }; // Mau Anh sang chieu
		float boPhanMat_shininess[] = { 0.0f }; // Muc do bao trum

		float mieng_specular[] = { 1.0f, 0.0f, 0.0f, 1.0f }; // Mau Anh sang chieu
		float mieng_shininess[] = { 0.0f }; // Muc do bao trum

		float Than_specular[] = { 0.0f, 0.5f, 0.0f, 1.0f }; // Mau Anh sang chieu
		float Than_shininess[] = { -100.0f }; // Muc do bao trum

		float mat_specularCo[] = { 1.0f, 1.0f, 0.0f, 1.0f }; // Mau Anh sang chieu
		float mat_shininessCo[] = { -100.0f }; // Muc do bao trum

		float chan_specular[] = { 1.0f, 0.0f, 0.0f, 1.0f }; // Mau Anh sang chieu
		float chan_shininess[] = { -100.0f }; // Muc do bao trum

		float cachTay_specular[] = { 0.0f, 0.0f, 1.0f, 0.0f }; // Mau Anh sang chieu
		float cachTay_shininess[] = { -100.0f }; // Muc do bao trum

		float banhXe[] = { 0.0f, 0.5f, 0.0f, 1.0f }; // Mau Anh sang chieu

		float xanhDam[] = { 0.0f, 0.4f, 0.1f, 0.0f };
		float xanh[] = { 0.0f, 1.0f, 0.0f, 0.0f };
		float daTroi[] = { 0.0f, 1.0f, 1.0f, 0.0f };
		float hong[] = { 0.5f, 0.5f, 0.5f, 0.0f };
		float tim[] = { 1.0f, 0.0f, 1.0f, 1.0f };
		float timXanh [] = {0.0f, 1.0f, 1.0f, 1.0f };
		float cam[] = { 0.5f, 0.5f, 0.0f, 0.0f };
		float trang[] = { 0.3f, 0.3f, 1.0f, 0.0f };
		float trangSang[] = { 0.6f, 1.0f, 1.0f, 0.0f };
		float den[] = { 0.0f, 0.0f, 0.0f, 0.0f };

		float no_mat[] = { 0.0f, 0.0f, 0.0f, 1.0f };
		float mat_ambient[] = { 0.7f, 0.7f, 0.7f, 1.0f };
		float mat_diffuse[] = { 0.1f, 0.5f, 0.8f, 1.0f };
		float no_shininess[] = { 0.0f };
		float mat_emission[] = { 0.3f, 0.2f, 0.2f, 0.0f };
		float Do[] = { 1.0f, 0.0f, 0.0f, 0.0f };

		GLUquadricObj qobj;
		float non_specular[] = { 0.0f, 1.0f, 1.0f, 1.0f };

		// ---Room----//
		myGL.glPushMatrix();

		myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glTranslated(xkhonggian, 0.0, t);
		myGL.glRotatef(r, 0.0f, 1.0f, 0.0f);
		myGL.glScaled(22.0, 12.0, 20.0);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[0]); // texName [0] -> checkImage
		myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, -2.0f, -2.0f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[1]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, -2.0f, -2.0f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[2]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-2.0f, -2.0f, -2.0f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[3]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, 2.0f, 2.0f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[4]);

		myGL.glPushMatrix(); 
		myGL.glBegin(GL.GL_QUADS); 
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-xNuoc, -yNuoc, zNuoc);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-xNuoc, -yNuoc, -zNuoc);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(xNuoc, -yNuoc, -zNuoc);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(xNuoc, -yNuoc, zNuoc);
		myGL.glEnd();
		myGL.glPopMatrix();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, -2.0f, 2.0f);
		myGL.glEnd();

		///////////////////////// KHUNG NHA ////////////////////////////////////////////

		myGL.glTranslated(1.5, -1.3, -2.0);
		myGL.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
//		myGL.glScaled(2.5, 0.5, 0.5);
		myGL.glScaled(0.85, 1.25, 1.0);


		// NHO NHA GOC PHAI
//				myGL.glScalef(0.5f, 0.5f, 0.5f);
				
		myGL.glPushMatrix();
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]); // texName [0] -> checkImage
		myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, -0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, -0.5f, -0.5f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, -0.5f, -0.5f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-0.5f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-0.5f, -0.5f, -0.5f);

		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[9]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, 0.5f, 0.5f);

		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, -0.5f, 0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, -0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, -0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, -0.5f, 0.5f);

		myGL.glEnd();

		//================= NOC NHA ===============================//
		
		myGL.glTranslated(-0.02, 0.62, -0.25);
		myGL.glRotatef(rNocNha, 1.0f, 0.0f, 0.0f);
		myGL.glScaled(1.1, 0.75, 0.75);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.0f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.0f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.75f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.75f, -0.5f, -0.5f);
		myGL.glEnd();

//		myGL.glScaled(6.0, 6.0, 2.0);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[12]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.0f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.0f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-0.75f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-0.75f, -0.5f, -0.5f);
		myGL.glEnd();

//		myGL.glScaled(0.1, 0.1, 0.1);
		myGL.glTranslated(0.0, -0.5, 0.0);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[13]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, -0.5f, 0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, -0.5f, 0.5f);

		myGL.glEnd();

		myGL.glPopMatrix();

		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glPopMatrix();

		// ----------------------- MAY BAY -------------------------------------//
		myGL.glPushMatrix();

		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
		myGL.glDepthFunc(GL.GL_LESS);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glTranslatef(xMayBay + 20.0f, 7.5f, zMayBay);
		myGL.glRotated(rMayBay, 1.0, 0.0, 0.0);
		myGL.glTranslatef(0.0f, 1.0f, 0.0f);

		myGL.glScalef(3f, 3f, 3f);
		
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(3.5f, 0.6f, 0.6f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.5f, -0.3f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, daTroi); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 1.5f, 1.0f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.6f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, daTroi); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 1.5f, 1.0f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(1.25f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, daTroi); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 0.7f, 0.7f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		// -----------------MAY BAY 2-------------------------//
		myGL.glTranslatef(-3.0f, 1.0f, 0.0f);

		// NHO MAY BAY
//				myGL.glScalef(0.5f, 0.5f, 0.5f);
				
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(3.5f, 0.6f, 0.6f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.5f, -0.3f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 1.5f, 1.0f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.6f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 1.5f, 1.0f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(1.25f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 0.7f, 0.7f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glPopMatrix();

		/////////////////////////////////////////////////////////////////////
		myGL.glPushMatrix();
		myGL.glTranslated(xRoBot, yRoBot, t + 10);
		myGL.glRotatef(rotatef, xThuyen, yThuyen, zThuyen);
		// TO THUYEN CON ROBOT
//				myGL.glScalef(2.5f, 2.5f, 2.5f);
//		myGL.glScalef(1.5f, 1.5f, 1.5f);

		// -------------------------------------------------------------//
		myGL.glPushMatrix();

		myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
		myGL.glDepthFunc(GL.GL_LESS);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glDisable(GL.GL_TEXTURE_2D);

		// Nho robot
		myGL.glScalef(x2, y2, z2);
//				myGL.glScalef(2.0f, 1.0f, 0.15f);
		// ThAN

		myGL.glTranslatef(tx, ty, 2.0f);
		myGL.glRotatef((float) shoulderX, x1, y1, z1);
		myGL.glTranslatef(tqx, tqy, 0.0f);

		myGL.glTranslatef(-0.25f, -0.6f, 1.5f);
		myGL.glRotatef((float) -90, 1.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) -180, 0.0f, 0.0f, 1.0f);

		myGL.glPushMatrix();

		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Than_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, Than_shininess); // khong ve mau bao trum
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambient);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_diffuse);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, mat_emission);
		myGL.glScalef(1.0f, 1.0f, 0.5f);
		myUT.glutSolidCube(1);

		// CÃ¡nh tay trai

		myGL.glPushMatrix();
		//
		myGL.glTranslatef(0.75f, 0.5f, 0.0f);
		myGL.glRotatef((float) shoulderTT, x1, y1, 0.0f);
		myGL.glTranslatef(tqttx, tqtty, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, chan_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, chan_shininess); // khong ve mau bao trum
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambient);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_diffuse);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, mat_emission);
		myGL.glScalef(0.5f, 0.5f, 0.5f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.4f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambient);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_diffuse);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, mat_emission);
		myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) elbowTT, x1, y1, 0.0f);
		myGL.glTranslatef(0.0f, -0.5f, ct);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cachTay_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, cachTay_shininess); // khong ve mau bao trum
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambient);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_diffuse);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, mat_emission);
		myGL.glScalef(0.4f, 1.0f, 0.5f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambient);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_diffuse);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, mat_emission);
		myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glPopMatrix();

		// CÃ¡nh tay phai

		myGL.glPushMatrix();

		myGL.glTranslatef(-0.75f, 0.5f, 0.0f);
		myGL.glRotatef((float) shoulderTP, x1, y1, 0.0f);
		myGL.glTranslatef(tqtpx, tqtpy, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, chan_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, chan_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 0.5f, 0.5f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.4f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) elbowTP, x1, y1, 0.0f);
		myGL.glTranslatef(0.0f, -0.5f, ct);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cachTay_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, cachTay_shininess); // khong ve mau bao trum
		myGL.glScalef(0.4f, 1.0f, 0.5f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glPopMatrix();
		// ---------------------//

		myGL.glPopMatrix();
		// -------------------//
		// -------------------------//

		// Cá»•
		myGL.glPushMatrix();
		myGL.glTranslatef(tcx, tcy, 0.0f);
		myGL.glRotatef((float) shoulderXC, x1, y1, 0.0f);
		myGL.glTranslatef(tqcx, tqcy, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Than_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, chan_specular); // khong ve mau bao trum
		myGL.glScalef(0.25f, 0.2f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
//				myUT.glutSolidSphere(0.5f, 10, 8);

		// ------------------------//

		// Dau

		myGL.glTranslated(0.0f, 0.5f, 0.0f); // Dich chuyen hinh lai cho cu
		myGL.glRotatef((float) shoulderXD, x1, y1, 0.0f);
		myGL.glTranslated(0.0f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslated(-0.19f, 0.0f, 0.39f); // Dich chuyen hinh lai cho cu
		myGL.glRotatef((float) shoulderXD, x1, y1, 0.0f);
		myGL.glTranslated(0.0f, 0.0f, 0.0f);

//				myGL.glColor3f(1.0f, 1.0f, 1.0f);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, boPhanMat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, boPhanMat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslated(0.19f, 0.0f, 0.39f); // Dich chuyen hinh lai cho cu
		myGL.glRotatef((float) shoulderXD, x1, y1, 0.0f);
		myGL.glTranslated(0.0f, 0.0f, 0.0f);

//				myGL.glColor3f(1.0f, 1.0f, 1.0f);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, boPhanMat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, boPhanMat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslated(0.0f, -0.2f, 0.39f); // Dich chuyen hinh lai cho cu
		myGL.glRotatef((float) shoulderXD, x1, y1, 0.0f);
		myGL.glTranslated(0.0f, 0.0f, 0.0f);

//				myGL.glColor3f(1.0f, 0.0f, 0.0f);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mieng_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mieng_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1f, 10, 8); /* váº½ hÃ¬nh trÃ²n */

		myGL.glPushMatrix();
		startList = myGL.glGenLists(4);
		qobj = myGLU.gluNewQuadric();
		myGLU.gluQuadricCallback(qobj, myGLU.GLU_ERROR, "errorCallback");

		myGLU.gluQuadricDrawStyle(qobj, GLU.GLU_FILL); /* flat shaded */
		myGLU.gluQuadricNormals(qobj, GLU.GLU_FLAT);
		myGL.glNewList(startList + 1, GL.GL_COMPILE);
		myGLU.gluCylinder(qobj, 0.65, 0.0, 0.5, 15, 5);
		myGL.glEndList();

		myGL.glTranslatef(0.0f, 0.4f, -0.4f);
//				myGL.glMaterialfv (GL.GL_FRONT, GL.GL_AMBIENT, mat_ambient);
//				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, non_specular);
		myGL.glRotatef(270.0f, 2.0f, 0.0f, 0.0f);
		myGL.glCallList(startList + 1);
		myGL.glPopMatrix();

		myGL.glPopMatrix();

		myGL.glPopMatrix();

		// ---------------------------------------------------//
//				myGL.glPopMatrix();

		// CANH CHAN TRAI
		
		myGL.glPushMatrix();

		myGL.glTranslated(0.3f, -0.5f, 0.0f);
		myGL.glRotatef((float) shoulderCT, x11, y11, z11);
		myGL.glTranslated(tqctx, tqcty, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, chan_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, chan_shininess); // khong ve mau bao trum
		myGL.glScalef(0.4f, 1.0f, 0.5f);
		myUT.glutSolidCube(1);

		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) elbowCT, 1.0f, y11, z11);
		myGL.glTranslatef(0.0f, -0.6f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cachTay_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, cachTay_shininess); // khong ve mau bao trum
		myGL.glScalef(0.4f, 1.0f, 0.5f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, cachTay_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 0.2f, 0.5f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glPopMatrix();
		// ------------------------//

		// CANH CHAN PHAI
		myGL.glPushMatrix();

		myGL.glTranslated(-0.3f, -0.5f, 0.0f);
		myGL.glRotatef((float) shoulderCP, x11, y11, z11);
		myGL.glTranslated(tqcpx, tqcpy, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, chan_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, chan_shininess); // khong ve mau bao trum
		myGL.glScalef(0.4f, 1.0f, 0.5f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) elbowCP, 1.0f, y11, z11);
		myGL.glTranslatef(0.0f, -0.6f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cachTay_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, cachTay_shininess); // khong ve mau bao trum
		myGL.glScalef(0.4f, 1.0f, 0.5f);
		myUT.glutSolidCube(1);

		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, cachTay_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 0.2f, 0.5f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glTranslatef(2.0f, -0.6f, -1.0f);
		myGL.glRotatef((float) 45, 0.0f, 0.0f, 1.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, cachTay_shininess); // khong ve mau bao trum
		myGL.glScalef(0.1f, 2.5f, 0.1f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glTranslatef(-2.0f, 2.75f, 0.5f);
		myGL.glRotatef((float) 90, 0.0f, 0.0f, 1.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, cachTay_shininess); // khong ve mau bao trum
		myGL.glScalef(0.1f, 2.5f, 0.1f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glPopMatrix();
		// -------------------------//

		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glPopMatrix();
		// ---------------------------------------------------//
		myGL.glPushMatrix();

		myGL.glScaled(1.0, 0.75, 0.75);

		myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8
		myGL.glColor3f(1.0f, 1.0f, 1.0f);
		myGL.glEvalMesh2(GL.GL_FILL, 0, 20, 0, 20);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
		myGL.glPopMatrix();
		myGL.glPopMatrix();

		// ------------------KINH KHI CAU-------------------------//
		myGL.glPushMatrix();

		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
		myGL.glDepthFunc(GL.GL_LESS);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glScalef(5.0f, 5.0f, 5.0f);
		 

		myGL.glTranslatef(-4.0f, yKinhKhiCau, 1.0f);
		myGL.glRotated(rKinhKhiCau, 0.0, 1.0, 0.0);
		myGL.glTranslatef(0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(1.0f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.7f, 0.7f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.7f, 0.7f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, daTroi); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 45, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -1.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, daTroi); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.05f, 0.4f, 0.05f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.5f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.45f, 0.45f, 0.45f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glPopMatrix();
		// -----------------------------------------------------------//

		// ------------------KINH KHI CAU 2 -------------------------//
		myGL.glPushMatrix();

		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
		myGL.glDepthFunc(GL.GL_LESS);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glScalef(2.0f, 2.0f, 2.0f);

		// NHO HOA KINH KHI CAU
//				myGL.glScalef(0.5f, 0.5f, 0.5f);
				
		myGL.glTranslatef(-4.0f, yKinhKhiCau + 1.0f, 1.0f);
		myGL.glRotated(rKinhKhiCau, 0.0, 1.0, 0.0);
		myGL.glTranslatef(0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(1.0f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.7f, 0.7f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.7f, 0.7f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, daTroi); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 45, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.73f, 0.73f, 0.5f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -1.0f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, daTroi); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.05f, 0.4f, 0.05f);
		myUT.glutSolidSphere(1.5f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.5f, 0.0f);
		myGL.glRotatef((float) 40, 0.0f, 1.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.45f, 0.45f, 0.45f);
//				myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glPopMatrix();
		// ------------------------------------------------------//

		// ------------------RUA -------------------------------//
		myGL.glPushMatrix();

		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
		myGL.glDepthFunc(GL.GL_LESS);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glTranslatef(xRua, -10.5f, 25.0f);
		myGL.glRotated(rRua, 0.0, 1.0, 0.0);
		myGL.glTranslatef(0.0f, 1.0f, 0.0f);


		// TO RUA
//				myGL.glScalef(2.5f, 2.5f, 2.5f);
				
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(1.0, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(1.25f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.75, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(-2.0f, -0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.3, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(1.0f, -0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.3, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.75f, 0.1f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.3, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(-1.0f, 1.0f, -1.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.3, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(1.25f, 0.2f, 1.7f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, den); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.5f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, den); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.25f, -0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glTranslatef(-1.55f, 0.6f, -0.25f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.7, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();

		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glPopMatrix();

		// -----------------CHIEC THUYEN-------------------------//

		myGL.glPushMatrix();

		myGL.glTranslated(10.0, -10.0, 30.0);
		myGL.glRotatef(244.0f, xThuyen, yThuyen, zThuyen);
		myGL.glScaled(1.5, 1.0, 1.0);

		// TO THUYEN
//				myGL.glScalef(3.0f, 2.0f, 2.0f);
				
		myGL.glPushMatrix();
		myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8
		myGL.glColor3f(1.0f, 1.0f, 1.0f);
		myGL.glEvalMesh2(GL.GL_FILL, 0, 20, 0, 20);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
		
		myGL.glPopMatrix();
		//=======CANH THUYEN========//
				myGL.glPushMatrix();
				myGL.glTranslated(0.5, -0.5, 3.0);
				myGL.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
				myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
				myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
				myGL.glDisable(GL.GL_TEXTURE_2D);
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(6.0f, 1.75f, 1.5f);
				myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
				
				myGL.glPushMatrix();
				myGL.glTranslated(0.0, 0.0, -0.5);
				myGL.glRotatef(-165.0f, 0.0f, 1.0f, 0.0f);
				myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
				myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
				myGL.glDisable(GL.GL_TEXTURE_2D);
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(0.75f, 0.75f, 0.5f);
				myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
				myGL.glPopMatrix();
				
				myGL.glPopMatrix();
				
		//====CANH THUYEN==========//
				
		myGL.glPopMatrix();

		// -----------------CHIEC THUYEN-------------------------//

		myGL.glPushMatrix();

		myGL.glTranslated(-9.0, -11.0, 30.0);
		myGL.glRotatef(240.0f, xThuyen, yThuyen, zThuyen);
		myGL.glScaled(1.0, 0.75, 0.75);
		

		// TO THUYEN
//				myGL.glScalef(2.0f, 2.0f, 2.0f);
				
		myGL.glPushMatrix();
		myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8
		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glColor3f(1.0f, 1.0f, 1.0f);
		myGL.glEvalMesh2(GL.GL_FILL, 0, 20, 0, 20);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
		myGL.glPopMatrix();
		//=======CANH THUYEN========//
		myGL.glPushMatrix();
		myGL.glTranslated(-1.25, 0.0 , 2.0);
		myGL.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(6.0f, 1.75f, 1.5f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		
		myGL.glPushMatrix();
		myGL.glTranslated(0.0, 0.0, -0.5);
		myGL.glRotatef(-165.0f, 0.0f, 1.0f, 0.0f);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.75f, 0.75f, 0.5f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
		myGL.glPopMatrix();
		
		myGL.glPopMatrix();
		//====CANH THUYEN==========//
		myGL.glPopMatrix();

		// =================HOA ANH DAO=================================//

		 
		myGL.glTranslatef(-30.0f, 0.0f, 5.0f);
		for (int k = 0; k <= 2; k++) {
			myGL.glTranslatef(5.0f, 0.0f, 0.0f);
			myGL.glPushMatrix();

			myGL.glDisable(GL.GL_TEXTURE_2D);
			myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
			myGL.glDepthFunc(GL.GL_LESS);
			myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
			myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

			myGL.glTranslatef(4.0f - 15.0f, -19.5f, -4.0f - 15.0f);
//				myGL.glTranslatef(0.0f, 1.0f, 0.0f);

			// lAM NHỎ HOA ANH DAO MAU HONG GOC TRAI 
//			myGL.glScalef(0.5f, 0.5f, 0.5f);
			myGL.glScalef(1.5f, 1.5f, 1.5f);
			
			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 10.0f, 0.6f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glTranslatef(-1.0f, 0.0f, 0.0f);
			myGL.glScalef(1.5f, 1.5f, 1.5f);
			myGL.glRotated(45.0, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 3.0f, 0.6f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glTranslatef(2.0f, 0.0f, 0.0f);
			myGL.glScalef(1.5f, 1.5f, 1.5f);
			myGL.glRotated(50.0, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 2.0f, 0.2f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//	                myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Do); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}

			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(-0.3f, 0.7f, 0.0f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Do); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.2f, 0.2f, 0.2f);
					myUT.glutSolidCube(1);
					myGL.glPopMatrix();

				}
			}
			myGL.glTranslatef(-2.0f, 3.0f, 0.0f);
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//	                myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Do); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(-0.3f, 0.7f, 0.0f);
//	                myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Do); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.2f, 0.2f, 0.2f);
					myUT.glutSolidCube(1);
					myGL.glPopMatrix();

				}
			}

			myGL.glTranslatef(-3.0f, -1.0f, 0.0f);
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//	                myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Do); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}

			myGL.glTranslatef(-2.0f, -5.0f, -3.0f);
			myGL.glScalef(0.5f, 0.5f, 1.5f);
			myGL.glRotated(60, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 5.0f, 0.2f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glEnable(GL.GL_TEXTURE_2D);
			myGL.glPopMatrix();
		}
		// ==================================================================//
		
		// =================HOA ANH DAO =================================//

		myGL.glTranslatef(-25.0f, 10.0f, 0.0f);
		for (int k = 0; k <= 2; k++) {
			myGL.glTranslatef(5.0f, 0.0f, 0.0f);
			myGL.glPushMatrix();

			myGL.glDisable(GL.GL_TEXTURE_2D);
			myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
			myGL.glDepthFunc(GL.GL_LESS);
			myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
			myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

			myGL.glTranslatef(4.0f - 15.0f, -19.5f, -4.0f - 15.0f);
//		myGL.glTranslatef(0.0f, 1.0f, 0.0f);

			myGL.glScalef(1.5f, 1.5f, 1.5f);
			
			// NHO HOA ANH DAO PHIA BEN TRAI MAU XANH
//			myGL.glScalef(0.5f, 0.5f, 0.5f);
			
			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 10.0f, 0.6f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glTranslatef(-1.0f, 0.0f, 0.0f);
			myGL.glScalef(1.5f, 1.5f, 1.5f);
			myGL.glRotated(45.0, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 3.0f, 0.6f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glTranslatef(2.0f, 0.0f, 0.0f);
			myGL.glScalef(1.5f, 1.5f, 1.5f);
			myGL.glRotated(50.0, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 2.0f, 0.2f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//            myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}

			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(-0.3f, 0.7f, 0.0f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.2f, 0.2f, 0.2f);
					myUT.glutSolidCube(1);
					myGL.glPopMatrix();

				}
			}
			myGL.glTranslatef(-2.0f, 3.0f, 0.0f);
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//            myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(-0.3f, 0.7f, 0.0f);
//            myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.2f, 0.2f, 0.2f);
					myUT.glutSolidCube(1);
					myGL.glPopMatrix();

				}
			}

			myGL.glTranslatef(-3.0f, -1.0f, 0.0f);
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//            myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}

			myGL.glTranslatef(-2.0f, -5.0f, -3.0f);
			myGL.glScalef(0.5f, 0.5f, 1.5f);
			myGL.glRotated(60, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanhDam); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 5.0f, 0.2f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glEnable(GL.GL_TEXTURE_2D);

			myGL.glPopMatrix();
		}
//===============================================================//

//=================HOA ANH DAO 2=================================//

		myGL.glTranslatef(55.0f, -5.0f, 25.0f);
		for (int k = 0; k <= 2; k++) {
//			myGL.glRotated(90.0, 0.0, 1.0, 0.0);
			myGL.glTranslatef(5.0f, 0.0f, 0.0f);
			myGL.glPushMatrix();

			myGL.glDisable(GL.GL_TEXTURE_2D);
			myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
			myGL.glDepthFunc(GL.GL_LESS);
			myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
			myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

			myGL.glTranslatef(4.0f - 15.0f, -19.5f, -4.0f - 15.0f);
//	myGL.glTranslatef(0.0f, 1.0f, 0.0f);

			myGL.glScalef(1.0f, 1.0f, 1.0f);
			
			// NHO HOA ANH DAO PHIA BEN PHAI MAU VANG
//			myGL.glScalef(0.5f, 0.5f, 0.5f);
			
			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 10.0f, 0.6f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glTranslatef(-1.0f, 0.0f, 0.0f);
			myGL.glScalef(1.5f, 1.5f, 1.5f);
			myGL.glRotated(45.0, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 3.0f, 0.6f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glTranslatef(2.0f, 0.0f, 0.0f);
			myGL.glScalef(1.5f, 1.5f, 1.5f);
			myGL.glRotated(50.0, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 2.0f, 0.2f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//       myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}

			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(-0.3f, 0.7f, 0.0f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.2f, 0.2f, 0.2f);
					myUT.glutSolidCube(1);
					myGL.glPopMatrix();

				}
			}
			myGL.glTranslatef(-2.0f, 3.0f, 0.0f);
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//       myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(-0.3f, 0.7f, 0.0f);
//       myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.2f, 0.2f, 0.2f);
					myUT.glutSolidCube(1);
					myGL.glPopMatrix();

				}
			}

			myGL.glTranslatef(-3.0f, -1.0f, 0.0f);
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//       myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}

			myGL.glTranslatef(-2.0f, -5.0f, -3.0f);
			myGL.glScalef(0.5f, 0.5f, 1.5f);
			myGL.glRotated(60, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 5.0f, 0.2f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glEnable(GL.GL_TEXTURE_2D);
			myGL.glPopMatrix();
		}
//==================================================================//
		
//=================HOA ANH DAO=================================//

		myGL.glTranslatef(-18.0f, 10.0f, 8.0f);
		for (int k = 0; k <= 2; k++) {
			myGL.glTranslatef(5.0f, 0.0f, 0.0f);
			myGL.glPushMatrix();

			myGL.glDisable(GL.GL_TEXTURE_2D);
			myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
			myGL.glDepthFunc(GL.GL_LESS);
			myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
			myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

			myGL.glTranslatef(4.0f - 15.0f, -19.5f, -4.0f - 15.0f);
//myGL.glTranslatef(0.0f, 1.0f, 0.0f);

			myGL.glScalef(1.0f, 1.0f, 1.0f);

			// NHO HOA ANH DAO PHIA BEN PHAI MAU XANH
//			myGL.glScalef(0.5f, 0.5f, 0.5f);
			
			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 10.0f, 0.6f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glTranslatef(-1.0f, 0.0f, 0.0f);
			myGL.glScalef(1.5f, 1.5f, 1.5f);
			myGL.glRotated(45.0, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 3.0f, 0.6f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glTranslatef(2.0f, 0.0f, 0.0f);
			myGL.glScalef(1.5f, 1.5f, 1.5f);
			myGL.glRotated(50.0, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 2.0f, 0.2f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}

			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(-0.3f, 0.7f, 0.0f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.2f, 0.2f, 0.2f);
					myUT.glutSolidCube(1);
					myGL.glPopMatrix();

				}
			}
			myGL.glTranslatef(-2.0f, 3.0f, 0.0f);
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(-0.3f, 0.7f, 0.0f);
//myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.2f, 0.2f, 0.2f);
					myUT.glutSolidCube(1);
					myGL.glPopMatrix();

				}
			}

			myGL.glTranslatef(-3.0f, -1.0f, 0.0f);
			for (float i = 0.0f; i <= 10.0f; i++) {
				myGL.glRotated(270, 1.0, 0.0, 1.0);
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f);
//myGL.glScalef(0.01f,0.01f, 0.01f);
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				}
			}

			myGL.glTranslatef(-2.0f, -5.0f, -3.0f);
			myGL.glScalef(0.5f, 0.5f, 1.5f);
			myGL.glRotated(60, 0.0, 0.0, 1.0);

			myGL.glPushMatrix();
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanhDam); // khong hien thi mau
			myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
			myGL.glScalef(1.0f, 5.0f, 0.2f);
			myUT.glutSolidSphere(0.4f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
			myGL.glPopMatrix();

			myGL.glEnable(GL.GL_TEXTURE_2D);
			myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
			myGL.glDepthFunc(GL.GL_LESS);
			myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
			myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8

			myGL.glPopMatrix();

		}

//======================NGOI NHA GOC TRAI ==============================//
		myGL.glPushMatrix();

		myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glDisable(GL.GL_LIGHT0); // Bat den 1
		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glTranslated(-55.5, -32.3, -55.0);
		myGL.glRotatef(185.0f, 0.0f, 1.0f, 0.0f);
//		myGL.glScaled(2.5, 0.5, 0.5);
		myGL.glScaled(6.0, 6.5, 6.0);
 

		// TO NGOI NHA GAN HOA DAO
//				myGL.glScalef(2.5f, 2.5f, 2.5f);
				
		myGL.glPushMatrix();
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]); // texName [0] -> checkImage
		myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, -0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, -0.5f, -0.5f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, -0.5f, -0.5f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-0.5f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-0.5f, -0.5f, -0.5f);

		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[9]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, 0.5f, 0.5f);

		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, -0.5f, 0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, -0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, -0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, -0.5f, 0.5f);

		myGL.glEnd();

		myGL.glTranslated(-0.035, 0.55, -0.25);
		myGL.glRotatef(rNocNha, 1.0f, 0.0f, 0.0f);
		myGL.glScaled(1.25, 0.75, 1.75);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.0f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.0f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.75f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.75f, -0.5f, -0.5f);
		myGL.glEnd();

//		myGL.glScaled(6.0, 6.0, 2.0);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[12]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.0f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.0f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-0.75f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-0.75f, -0.5f, -0.5f);
		myGL.glEnd();

		myGL.glPopMatrix();

		// ========================================================//

		// ======================NGOI NHA 2 ==============================//
		myGL.glPushMatrix();

		myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glDisable(GL.GL_LIGHT0); // Bat den 1
		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glTranslated(3.5, 0.0, -4.0);
		myGL.glRotatef(90.0f, 0.0f, 1.0f, 0.0f); 
		myGL.glScaled(1.0, 1.25, 1.5);

		// NGOI NHA GOC TRAI 
//		myGL.glScalef(0.5f, 0.5f, 0.5f);
		
		myGL.glPushMatrix();
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]); // texName [0] -> checkImage
		myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, -0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, -0.5f, -0.5f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, -0.5f, -0.5f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-0.5f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-0.5f, -0.5f, -0.5f);

		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[9]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, 0.5f, 0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, 0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, 0.5f, 0.5f);

		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.5f, -0.5f, 0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.5f, -0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.5f, -0.5f, -0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.5f, -0.5f, 0.5f);

		myGL.glEnd();

		myGL.glTranslated(-0.02, 0.7, -0.1);
		myGL.glRotatef(rNocNha, 1.0f, 0.0f, 0.0f);
		myGL.glScaled(1.0, 0.75, 1.25);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.0f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.0f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.75f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.75f, -0.5f, -0.5f);
		myGL.glEnd();

//				myGL.glScaled(6.0, 6.0, 2.0);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[12]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.0f, 0.5f, -0.5f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.0f, 0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-0.75f, -0.5f, 0.5f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-0.75f, -0.5f, -0.5f);
		myGL.glEnd();

		// ========================================================//

		myGL.glPopMatrix();

//================== HOA GAN NHA =============================================//
		
		myGL.glPushMatrix();
		myGL.glTranslatef(-5.0f, 0.3f, -6.0f); 
		
		// NHO HOA GAN NHA
//		myGL.glScalef(0.5f, 0.5f, 0.5f);
		
		for (float i = 0.0f; i <= 10.0f; i++) {
			myGL.glRotated(270, 1.0, 0.0, 1.0);
			myGL.glDisable(GL.GL_TEXTURE_2D);
			myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
			myGL.glDepthFunc(GL.GL_LESS);
			myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
			myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
			 
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.15f, 0.15f, 0.0f); 
					myGL.glRotated(45, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.5f, 0.5f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				} 
		myGL.glEnable(GL.GL_TEXTURE_2D);
		}
		
		//===============================================================//
		
		myGL.glPushMatrix();
		myGL.glTranslatef(-0.2f, 0.0f, -0.5f); 
		
		for (float i = 0.0f; i <= 10.0f; i++) {
			myGL.glRotated(270, 1.0, 0.0, 1.0);
			myGL.glDisable(GL.GL_TEXTURE_2D);
			myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
			myGL.glDepthFunc(GL.GL_LESS);
			myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
			myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
			 
				for (float j = 0.0f; j <= 8.0f; j++) {
					myGL.glTranslatef(0.1f, 0.1f, 0.0f); 
					myGL.glRotated(-35.0f, 0.0, 0.0, 1.0);

					myGL.glPushMatrix();
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
					myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
					myGL.glScalef(0.5f, 0.1f, 0.1f);
					myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
					myGL.glPopMatrix();

				} 
		myGL.glEnable(GL.GL_TEXTURE_2D);
		}
		myGL.glPopMatrix();
//==============================================================//
		
		//===================DA QUANH HOA============================================//
		
				myGL.glPushMatrix();
				myGL.glTranslatef(-1.4f, 0.0f, -1.0f); 
				 
					myGL.glRotated(rRua + 270, 1.0, 0.0, 1.0);
					myGL.glDisable(GL.GL_TEXTURE_2D);
					myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
					myGL.glDepthFunc(GL.GL_LESS);
					myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
					myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
					 
						for (float j = 0.0f; j <= 8.0f; j++) {
							myGL.glTranslatef(0.17f, 0.17f, 0.0f); 
							myGL.glRotated(-35.0f, 0.0, 0.0, 1.0);

							myGL.glPushMatrix();
							myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, den ); // khong hien thi mau
							myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
							myGL.glScalef(0.5f, 0.5f, 0.5f);
							myUT.glutSolidSphere(0.2f, 10, 8); /* váº½ hÃ¬nh trÃ²n */
							myGL.glPopMatrix();

						} 
				myGL.glEnable(GL.GL_TEXTURE_2D); 
				myGL.glPopMatrix();
		//==============================================================//
		
		myGL.glPopMatrix();
//==============================================================//
				
		myGL.glFlush();

	}

	public void myReshape(int w, int h) {
		myGL.glViewport(0, 0, w, h);
		myGL.glMatrixMode(GL.GL_PROJECTION);
		myGL.glLoadIdentity();
		myGLU.gluPerspective(60.0f, 1.0 * (double) w / (double) h, 1.0, 100.0);

	}

	public void quayVongQuanh() {
		
		rKinhKhiCau = (rKinhKhiCau - 5) % 360;
		yKinhKhiCau = yKinhKhiCau + 0.05f;
		xMayBay = xMayBay - 0.5f;
		// -----------------------//
		yThuyen = 1.0f;
		zThuyen = 1.0f;
//		rotatef = rotatef + 35.0f; 
		xRoBot = xRoBot - 0.06;
		yRoBot = yRoBot - 0.06;
		t = t + 0.1;
		xRua = xRua + 0.5f;

		xNuoc = xNuoc + 0.5f;
//		zNuoc = zNuoc + 0.1f ;
		myUT.glutPostRedisplay();
		
	}

	/* ARGSUSED2 */
	public void mouse(int button, int state, int x, int y) {
		if (button == GLUT.GLUT_LEFT_BUTTON) {
			if (state == GLUT.GLUT_DOWN) {
				myUT.glutIdleFunc("quayVongQuanh");
			}
		} else if (button == GLUT.GLUT_MIDDLE_BUTTON) { // Di ve phia truoc
			if (state == GLUT.GLUT_DOWN) {
				myUT.glutIdleFunc("quayVongQuanh");
			}
		}
	}
	
	public void keyboard(char key, int x, int y) {
		switch (key) {
		case 27:
			System.exit(0);
			break;
		case 'l':
			xLookAt = (xLookAt + 5.0f) % 360;
			myUT.glutPostRedisplay();
			break;
		case 'L':
			xLookAt = (xLookAt - 5.0f) % 360;
			myUT.glutPostRedisplay();
			break;
		case 'p':
			yLookAt = (yLookAt + 5.0f) % 360;
			myUT.glutPostRedisplay();
			break;
		case 'P':
			yLookAt = (yLookAt - 5.0f) % 360;
			myUT.glutPostRedisplay();
			break;
		case 'n':
			xNuoc = xNuoc + 0.1f;
			zNuoc = zNuoc + 0.1f;
			myUT.glutPostRedisplay();
			break;
		case 's':
			yThuyen = 1.0f;
			zThuyen = 1.0f;
			rotatef = rotatef + 20.0f;
//			t = t + 0.1 ;
			myUT.glutPostRedisplay();
			break;
		case 'S':
			xThuyen = 1.0f;
			zThuyen = 1.0f;
			rotatef = rotatef - 20.0f;
			myUT.glutPostRedisplay();
			break;
		case 'k':
			xThuyen = xThuyen + 5.0f;
			myUT.glutPostRedisplay();
			break;
		case 'K':
			xThuyen = xThuyen + 5.0f;
			myUT.glutPostRedisplay();
			break;

		case 'a':
			r = r + 3.0f;
			myUT.glutPostRedisplay();
			break;
		case 'A':
			r = r - 3.0f;
			myUT.glutPostRedisplay();
			break;
		case 'm':
			rKinhKhiCau = (rKinhKhiCau - 5) % 360;
			myUT.glutPostRedisplay();
			break;
		case 'M':
//			rDanCa = rDanCa + 0.1f ;
			rDanCa = (rDanCa - 5) % 360;
			System.out.println(rDanCa);
			myUT.glutPostRedisplay();
			break;
		case 'z': // Chay Tau
			rKinhKhiCau = (rKinhKhiCau - 5) % 360;
			yKinhKhiCau = yKinhKhiCau + 0.05f;
			xMayBay = xMayBay - 0.5f;
			// -----------------------//
			yThuyen = 1.0f;
			zThuyen = 1.0f;
//			rotatef = rotatef + 35.0f; 
			xRoBot = xRoBot - 0.06;
			yRoBot = yRoBot - 0.06;
			t = t + 0.1;
			xRua = xRua + 0.5f;

			xNuoc = xNuoc + 0.5f;
//			zNuoc = zNuoc + 0.1f ;
			myUT.glutPostRedisplay();
			break;

		case 'r':
			rRua = (rRua - 5) % 360;
			System.out.println(rRua);
			myUT.glutPostRedisplay();
			break;
		case 'x':
			x1 = x1 + 1.0f;
			y1 = y1 + 1.0f;
			myUT.glutPostRedisplay();
			break;
		case 'X':
			x1 = x1 - 1.0f;
			y1 = y1 - 1.0f;
			myUT.glutPostRedisplay();
			break;
		case 'v':
// 			r = (r + 4) % 360;
			t = t + 1.0;
			System.out.println(t);
			myUT.glutPostRedisplay();
			break;
		case 'V':
// 			r = (r + 4) % 360;
			t = t - 1.0;
			System.out.println(t);
			myUT.glutPostRedisplay();
			break;
		}

	}

	public void init() throws IOException {
		myUT.glutInitWindowSize(800, 800);
		myUT.glutInitWindowPosition(0, 0);
		myUT.glutCreateWindow(this);
		myinit();
		myUT.glutDisplayFunc("display");
		myUT.glutReshapeFunc("myReshape");
 		myUT.glutMouseFunc("mouse");
//		myUT.glutKeyboardFunc("keyboard");
		myUT.glutMainLoop();
	}

	static public void main(String args[]) throws IOException {
		Frame mainFrame = new Frame();
		mainFrame.setSize(1000, 700);
		ChiecThuyen mainCanvas = new ChiecThuyen();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
