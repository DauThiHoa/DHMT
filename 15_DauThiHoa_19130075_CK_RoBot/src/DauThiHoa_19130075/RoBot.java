package DauThiHoa_19130075;

/*
 * robot.java
 * This program shows how to composite modeling transformations
 * to draw translated and rotated hierarchical models.
 * Interaction:  pressing the s and e keys (shoulder and elbow)
 * alters the rotation of the robot arm.
 */

import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.lang.System;
import java.nio.Buffer;
import java.text.Collator;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.w3c.dom.css.RGBColor;

import jgl.GL;
import jgl.GLCanvas;
import jgl.GLU;
import jgl.GLUT;
import jgl.glu.GLUquadricObj;

public class RoBot extends GLCanvas {

	private int startList;

	public void errorCallback(int errorCode) {
		String estring;

		estring = myGLU.gluErrorString(errorCode);
		System.err.println("Quadric Error: " + estring);
	}

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
	// Lau1
	private byte imageCenterCanPhong[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRightCanPhong[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageLeftCanPhong[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageTopCanPhong[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBottomCanPhong[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBefoterCanPhong[][][] = new byte[checkImageWidth][checkImageHeight][4];
	// Lau2
	private byte imageCenterCanPhong2[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRightCanPhong2[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageLeftCanPhong2[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageTopCanPhong2[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBottomCanPhong2[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBefoterCanPhong2[][][] = new byte[checkImageWidth][checkImageHeight][4];

	// NocNha
	private byte imageRightNocNha[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageLeftNocNha[][][] = new byte[checkImageWidth][checkImageHeight][4];

	// ToaTau
	private byte imageCenterToaTau[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRightToaTau[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageLeftToaTau[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageTopToaTau[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBottomToaTau[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBefoterToaTau[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imagetToaTau[][][] = new byte[checkImageWidth][checkImageHeight][4];

	// Oto
	private byte imageCenterOto[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRightOto[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageLeftOto[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageTopOto[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBottomOto[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBefoterOto[][][] = new byte[checkImageWidth][checkImageHeight][4];

	private int texName[] = new int[33];

	private static float r = 0, rNha = 45;
	private static double t = -3.6, xkhonggian = 0.0, ykhonggian = 0.0;
	private static float yb = -1.5f;

	private void makeCheckImage() throws IOException {
		int i, j;
		float ti, tj;

		String str = "C:\\Users\\THINKPRO\\Pictures\\DHMT\\";

		File bmpCenterFile = new File(str + "center.bmp");
		File bmpRightFile = new File(str + "right.bmp");
		File bmpLeftFile = new File(str + "left.bmp");
		File bmpTopFile = new File(str + "top.bmp");
		File bmpBottomFile = new File(str + "bottom.bmp");
		File bmpBefoterFile = new File(str + "befoter.bmp");

		BufferedImage iCenter = ImageIO.read(bmpCenterFile);
		BufferedImage iRight = ImageIO.read(bmpRightFile);
		BufferedImage iLeft = ImageIO.read(bmpLeftFile);
		BufferedImage iTop = ImageIO.read(bmpTopFile);
		BufferedImage iBottom = ImageIO.read(bmpBottomFile);
		BufferedImage iBefoter = ImageIO.read(bmpBefoterFile);

		// ================CanPhong=====================
//		File bmpCenterFileCanPhong = new File(str + "centerCanPhong.bmp");
//		File bmpRightFileCanPhong = new File(str + "rightCanPhong.bmp");
//		File bmpLeftFileCanPhong = new File(str + "leftCanPhong.bmp");
//		File bmpTopFileCanPhong = new File(str + "topCanPhong.bmp");
//		File bmpBottomFileCanPhong = new File(str + "bottomCanPhong.bmp");
//		File bmpBefoterFileCanPhong = new File(str + "befoterCanPhong.bmp");
		
		File bmpCenterFileCanPhong = new File(str + "centerCanPhongLau2.bmp");
		File bmpRightFileCanPhong = new File(str + "rightCanPhongLau2.bmp");
		File bmpLeftFileCanPhong = new File(str + "leftCanPhongLau2.bmp");
		File bmpTopFileCanPhong = new File(str + "topCanPhongLau2.bmp");
		File bmpBottomFileCanPhong = new File(str + "bottomCanPhongLau2.bmp");
		File bmpBefoterFileCanPhong = new File(str + "befoterCanPhongLau2.bmp");

		BufferedImage iCenterCanPhong = ImageIO.read(bmpCenterFileCanPhong);
		BufferedImage iRightCanPhong = ImageIO.read(bmpRightFileCanPhong);
		BufferedImage iLeftCanPhong = ImageIO.read(bmpLeftFileCanPhong);
		BufferedImage iTopCanPhong = ImageIO.read(bmpTopFileCanPhong);
		BufferedImage iBottomCanPhong = ImageIO.read(bmpBottomFileCanPhong);
		BufferedImage iBefoterCanPhong = ImageIO.read(bmpBefoterFileCanPhong);

		// ================CanPhong=====================
//		File bmpCenterFileCanPhong2 = new File(str + "centerCanPhongLau2.bmp");
//		File bmpRightFileCanPhong2 = new File(str + "rightCanPhongLau2.bmp");
//		File bmpLeftFileCanPhong2 = new File(str + "leftCanPhongLau2.bmp");
//		File bmpTopFileCanPhong2 = new File(str + "topCanPhongLau2.bmp");
//		File bmpBottomFileCanPhong2 = new File(str + "bottomCanPhongLau2.bmp");
//		File bmpBefoterFileCanPhong2 = new File(str + "befoterCanPhongLau2.bmp");
		
		File bmpCenterFileCanPhong2 = new File(str + "centerCanPhong.bmp");
		File bmpRightFileCanPhong2 = new File(str + "rightCanPhong.bmp");
		File bmpLeftFileCanPhong2 = new File(str + "leftCanPhong.bmp");
		File bmpTopFileCanPhong2 = new File(str + "topCanPhong.bmp");
		File bmpBottomFileCanPhong2 = new File(str + "bottomCanPhong.bmp");
		File bmpBefoterFileCanPhong2 = new File(str + "befoterCanPhong.bmp");

		BufferedImage iCenterCanPhong2 = ImageIO.read(bmpCenterFileCanPhong2);
		BufferedImage iRightCanPhong2 = ImageIO.read(bmpRightFileCanPhong2);
		BufferedImage iLeftCanPhong2 = ImageIO.read(bmpLeftFileCanPhong2);
		BufferedImage iTopCanPhong2 = ImageIO.read(bmpTopFileCanPhong2);
		BufferedImage iBottomCanPhong2 = ImageIO.read(bmpBottomFileCanPhong2);
		BufferedImage iBefoterCanPhong2 = ImageIO.read(bmpBefoterFileCanPhong2);

		// ================NocNha=====================
		File bmpRightNocNha = new File(str + "nocNha.bmp");
		File bmpLeftNocNha = new File(str + "nocNha.bmp");

		BufferedImage iRightNocNha = ImageIO.read(bmpRightNocNha);
		BufferedImage iLeftNocNha = ImageIO.read(bmpLeftNocNha);

		// ================ToaTau=====================
		File bmpCenterFileToaTau = new File(str + "rightLeftTau.bmp");
		File bmpRightFileToaTau = new File(str + "centerTau.bmp");
		File bmpLeftFileToaTau = new File(str + "centerTau.bmp");
		File bmpTopFileToaTau = new File(str + "topTau.bmp");
		File bmpBottomFileToaTau = new File(str + "topTau.bmp");
		File bmpBefoterFileToaTau = new File(str + "rightLeftTau.bmp");
		File bmptFileToaTau = new File(str + "toaTau.bmp");

		BufferedImage iCenterToaTau = ImageIO.read(bmpCenterFileToaTau);
		BufferedImage iRightToaTau = ImageIO.read(bmpRightFileToaTau);
		BufferedImage iLeftToaTau = ImageIO.read(bmpLeftFileToaTau);
		BufferedImage iTopToaTau = ImageIO.read(bmpTopFileToaTau);
		BufferedImage iBottomToaTau = ImageIO.read(bmpBottomFileToaTau);
		BufferedImage iBefoterToaTau = ImageIO.read(bmpBefoterFileToaTau);
		BufferedImage itToaTau = ImageIO.read(bmptFileToaTau);

		// ================Oto=====================
		File bmpCenterFileOto = new File(str + "rightOto.bmp");
		File bmpRightFileOto = new File(str + "centerOto.bmp");
		File bmpLeftFileOto = new File(str + "centerOto.bmp");
		File bmpTopFileOto = new File(str + "topOto.bmp");
		File bmpBottomFileOto = new File(str + "topOto.bmp");
		File bmpBefoterFileOto = new File(str + "rightOto.bmp");

		BufferedImage iCenterOto = ImageIO.read(bmpCenterFileOto);
		BufferedImage iRightOto = ImageIO.read(bmpRightFileOto);
		BufferedImage iLeftOto = ImageIO.read(bmpLeftFileOto);
		BufferedImage iTopOto = ImageIO.read(bmpTopFileOto);
		BufferedImage iBottomOto = ImageIO.read(bmpBottomFileOto);
		BufferedImage iBefoterOto = ImageIO.read(bmpBefoterFileOto);

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

				// ===================CanPhong======================//
				Color cCenterCanPhong = new Color(iCenterCanPhong.getRGB(i, j));
				Color cRightCanPhong = new Color(iRightCanPhong.getRGB(i, j));
				Color cLeftCanPhong = new Color(iLeftCanPhong.getRGB(i, j));
				Color cTopCanPhong = new Color(iTopCanPhong.getRGB(i, j));
				Color cBottomCanPhong = new Color(iBottomCanPhong.getRGB(i, j));
				Color cBefoterCanPhong = new Color(iBefoterCanPhong.getRGB(i, j));

				imageCenterCanPhong[i][j][0] = (byte) (cCenterCanPhong.getRed());
				imageCenterCanPhong[i][j][1] = (byte) (cCenterCanPhong.getGreen());
				imageCenterCanPhong[i][j][2] = (byte) (cCenterCanPhong.getBlue());
				imageCenterCanPhong[i][j][3] = (byte) 225;

				imageRightCanPhong[i][j][0] = (byte) (cRightCanPhong.getRed());
				imageRightCanPhong[i][j][1] = (byte) (cRightCanPhong.getGreen());
				imageRightCanPhong[i][j][2] = (byte) (cRightCanPhong.getBlue());
				imageRightCanPhong[i][j][3] = (byte) 225;

				imageLeftCanPhong[i][j][0] = (byte) (cLeftCanPhong.getRed());
				imageLeftCanPhong[i][j][1] = (byte) (cLeftCanPhong.getGreen());
				imageLeftCanPhong[i][j][2] = (byte) (cLeftCanPhong.getBlue());
				imageLeftCanPhong[i][j][3] = (byte) 225;

				imageTopCanPhong[i][j][0] = (byte) (cTopCanPhong.getRed());
				imageTopCanPhong[i][j][1] = (byte) (cTopCanPhong.getGreen());
				imageTopCanPhong[i][j][2] = (byte) (cTopCanPhong.getBlue());
				imageTopCanPhong[i][j][3] = (byte) 225;

				imageBottomCanPhong[i][j][0] = (byte) (cBottomCanPhong.getRed());
				imageBottomCanPhong[i][j][1] = (byte) (cBottomCanPhong.getGreen());
				imageBottomCanPhong[i][j][2] = (byte) (cBottomCanPhong.getBlue());
				imageBottomCanPhong[i][j][3] = (byte) 225;

				imageBefoterCanPhong[i][j][0] = (byte) (cBefoterCanPhong.getRed());
				imageBefoterCanPhong[i][j][1] = (byte) (cBefoterCanPhong.getGreen());
				imageBefoterCanPhong[i][j][2] = (byte) (cBefoterCanPhong.getBlue());
				imageBefoterCanPhong[i][j][3] = (byte) 225;

				// ===================CanPhong2======================//
				Color cCenterCanPhong2 = new Color(iCenterCanPhong2.getRGB(i, j));
				Color cRightCanPhong2 = new Color(iRightCanPhong2.getRGB(i, j));
				Color cLeftCanPhong2 = new Color(iLeftCanPhong2.getRGB(i, j));
				Color cTopCanPhong2 = new Color(iTopCanPhong2.getRGB(i, j));
				Color cBottomCanPhong2 = new Color(iBottomCanPhong2.getRGB(i, j));
				Color cBefoterCanPhong2 = new Color(iBefoterCanPhong2.getRGB(i, j));

				imageCenterCanPhong2[i][j][0] = (byte) (cCenterCanPhong2.getRed());
				imageCenterCanPhong2[i][j][1] = (byte) (cCenterCanPhong2.getGreen());
				imageCenterCanPhong2[i][j][2] = (byte) (cCenterCanPhong2.getBlue());
				imageCenterCanPhong2[i][j][3] = (byte) 225;

				imageRightCanPhong2[i][j][0] = (byte) (cRightCanPhong2.getRed());
				imageRightCanPhong2[i][j][1] = (byte) (cRightCanPhong2.getGreen());
				imageRightCanPhong2[i][j][2] = (byte) (cRightCanPhong2.getBlue());
				imageRightCanPhong2[i][j][3] = (byte) 225;

				imageLeftCanPhong2[i][j][0] = (byte) (cLeftCanPhong2.getRed());
				imageLeftCanPhong2[i][j][1] = (byte) (cLeftCanPhong2.getGreen());
				imageLeftCanPhong2[i][j][2] = (byte) (cLeftCanPhong2.getBlue());
				imageLeftCanPhong2[i][j][3] = (byte) 225;

				imageTopCanPhong2[i][j][0] = (byte) (cTopCanPhong2.getRed());
				imageTopCanPhong2[i][j][1] = (byte) (cTopCanPhong2.getGreen());
				imageTopCanPhong2[i][j][2] = (byte) (cTopCanPhong2.getBlue());
				imageTopCanPhong2[i][j][3] = (byte) 225;

				imageBottomCanPhong2[i][j][0] = (byte) (cBottomCanPhong2.getRed());
				imageBottomCanPhong2[i][j][1] = (byte) (cBottomCanPhong2.getGreen());
				imageBottomCanPhong2[i][j][2] = (byte) (cBottomCanPhong2.getBlue());
				imageBottomCanPhong2[i][j][3] = (byte) 225;

				imageBefoterCanPhong2[i][j][0] = (byte) (cBefoterCanPhong2.getRed());
				imageBefoterCanPhong2[i][j][1] = (byte) (cBefoterCanPhong2.getGreen());
				imageBefoterCanPhong2[i][j][2] = (byte) (cBefoterCanPhong2.getBlue());
				imageBefoterCanPhong2[i][j][3] = (byte) 225;

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

				// ===================ToaTau======================//
				Color cCenterToaTau = new Color(iCenterToaTau.getRGB(i, j));
				Color cRightToaTau = new Color(iRightToaTau.getRGB(i, j));
				Color cLeftToaTau = new Color(iLeftToaTau.getRGB(i, j));
				Color cTopToaTau = new Color(iTopToaTau.getRGB(i, j));
				Color cBottomToaTau = new Color(iBottomToaTau.getRGB(i, j));
				Color cBefoterToaTau = new Color(iBefoterToaTau.getRGB(i, j));
				Color ctToaTau = new Color(itToaTau.getRGB(i, j));

				imageCenterToaTau[i][j][0] = (byte) (cCenterToaTau.getRed());
				imageCenterToaTau[i][j][1] = (byte) (cCenterToaTau.getGreen());
				imageCenterToaTau[i][j][2] = (byte) (cCenterToaTau.getBlue());
				imageCenterToaTau[i][j][3] = (byte) 225;

				imageRightToaTau[i][j][0] = (byte) (cRightToaTau.getRed());
				imageRightToaTau[i][j][1] = (byte) (cRightToaTau.getGreen());
				imageRightToaTau[i][j][2] = (byte) (cRightToaTau.getBlue());
				imageRightToaTau[i][j][3] = (byte) 225;

				imageLeftToaTau[i][j][0] = (byte) (cLeftToaTau.getRed());
				imageLeftToaTau[i][j][1] = (byte) (cLeftToaTau.getGreen());
				imageLeftToaTau[i][j][2] = (byte) (cLeftToaTau.getBlue());
				imageLeftToaTau[i][j][3] = (byte) 225;

				imageTopToaTau[i][j][0] = (byte) (cTopToaTau.getRed());
				imageTopToaTau[i][j][1] = (byte) (cTopToaTau.getGreen());
				imageTopToaTau[i][j][2] = (byte) (cTopToaTau.getBlue());
				imageTopToaTau[i][j][3] = (byte) 225;

				imageBottomToaTau[i][j][0] = (byte) (cBottomToaTau.getRed());
				imageBottomToaTau[i][j][1] = (byte) (cBottomToaTau.getGreen());
				imageBottomToaTau[i][j][2] = (byte) (cBottomToaTau.getBlue());
				imageBottomToaTau[i][j][3] = (byte) 225;

				imageBefoterToaTau[i][j][0] = (byte) (cBefoterToaTau.getRed());
				imageBefoterToaTau[i][j][1] = (byte) (cBefoterToaTau.getGreen());
				imageBefoterToaTau[i][j][2] = (byte) (cBefoterToaTau.getBlue());
				imageBefoterToaTau[i][j][3] = (byte) 225;

				imagetToaTau[i][j][0] = (byte) (ctToaTau.getRed());
				imagetToaTau[i][j][1] = (byte) (ctToaTau.getGreen());
				imagetToaTau[i][j][2] = (byte) (ctToaTau.getBlue());
				imagetToaTau[i][j][3] = (byte) 225;

				// ===================Oto======================//
				Color cCenterOto = new Color(iCenterOto.getRGB(i, j));
				Color cRightOto = new Color(iRightOto.getRGB(i, j));
				Color cLeftOto = new Color(iLeftOto.getRGB(i, j));
				Color cTopOto = new Color(iTopOto.getRGB(i, j));
				Color cBottomOto = new Color(iBottomOto.getRGB(i, j));
				Color cBefoterOto = new Color(iBefoterOto.getRGB(i, j));

				imageCenterOto[i][j][0] = (byte) (cCenterOto.getRed());
				imageCenterOto[i][j][1] = (byte) (cCenterOto.getGreen());
				imageCenterOto[i][j][2] = (byte) (cCenterOto.getBlue());
				imageCenterOto[i][j][3] = (byte) 225;

				imageRightOto[i][j][0] = (byte) (cRightOto.getRed());
				imageRightOto[i][j][1] = (byte) (cRightOto.getGreen());
				imageRightOto[i][j][2] = (byte) (cRightOto.getBlue());
				imageRightOto[i][j][3] = (byte) 225;

				imageLeftOto[i][j][0] = (byte) (cLeftOto.getRed());
				imageLeftOto[i][j][1] = (byte) (cLeftOto.getGreen());
				imageLeftOto[i][j][2] = (byte) (cLeftOto.getBlue());
				imageLeftOto[i][j][3] = (byte) 225;

				imageTopOto[i][j][0] = (byte) (cTopOto.getRed());
				imageTopOto[i][j][1] = (byte) (cTopOto.getGreen());
				imageTopOto[i][j][2] = (byte) (cTopOto.getBlue());
				imageTopOto[i][j][3] = (byte) 225;

				imageBottomOto[i][j][0] = (byte) (cBottomOto.getRed());
				imageBottomOto[i][j][1] = (byte) (cBottomOto.getGreen());
				imageBottomOto[i][j][2] = (byte) (cBottomOto.getBlue());
				imageBottomOto[i][j][3] = (byte) 225;

				imageBefoterOto[i][j][0] = (byte) (cBefoterOto.getRed());
				imageBefoterOto[i][j][1] = (byte) (cBefoterOto.getGreen());
				imageBefoterOto[i][j][2] = (byte) (cBefoterOto.getBlue());
				imageBefoterOto[i][j][3] = (byte) 225;

			}
		}
	}
	// -----------------------------------------------------------------------//
	
	public void disPlay () {
		float ambient[] = { 0.0f, 0.0f, 0.0f, 1.0f };
		float diffuse[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		float position[] = { 0.0f, 3.0f, 3.0f, 0.0f };
		
		float lmodel_ambient[] = { 0.2f, 0.2f, 0.2f, 1.0f };
		float local_view[] = { 0.0f };

		myGL.glLightfv (GL.GL_LIGHT0, GL.GL_AMBIENT, ambient);
		myGL.glLightfv (GL.GL_LIGHT0, GL.GL_DIFFUSE, diffuse);
		myGL.glLightfv (GL.GL_LIGHT0, GL.GL_POSITION, position);
		myGL.glLightModelfv (GL.GL_LIGHT_MODEL_AMBIENT, lmodel_ambient);
		myGL.glLightModelfv (GL.GL_LIGHT_MODEL_LOCAL_VIEWER, local_view);
	}
	private float spin = 0;

	private static double n = 0;
	private static double X = 0.35, Y = 0.2;
	private static double gluPerspective = 60.0;

	private static int shoulderXC = 0, elbow = 0, shoulderXD = 0, shoulderCT = 0, shoulderCP = 0;
	private static int shoulderX = 0, shoulderTP = 0, shoulderTT = 0, elbowTT = 0, elbowTP = 0, elbowCT = 0,
			elbowCP = 0;
	private static float x1 = 0.0f, y1 = 0.0f, z1 = 0.0f;
	private static float x11 = 0.0f, y11 = 0.0f, z11 = 0.0f;
	private static float x12 = 0.0f, y12 = 0.0f, z12 = 0.0f;
	private static float x2 = 0.5f, y2 = 0.5f, z2 = 0.15f;

	private static float ty = -4.5f, tx = 0.0f;
	private static float tqy = 0.5f, tqx = 0.0f;

	private static float tcx = 0.0f, tcy = 0.5f;
	private static float tqcx = 0.0f, tqcy = 0.1f;

	private static float tqttx = 0.0f, tqtty = -0.25f;
	private static float tqtpx = 0.0f, tqtpy = -0.25f;

	private static float tqctx = 0.0f, tqcty = -0.5f;
	private static float tqcpx = 0.0f, tqcpy = -0.5f;

	private static float ct = 0.0f;
	private static double xt = -1.5, yt = -0.2, zt = 1.2;
	private static double xOto = 6.0, yOto = -5.0, zOto = -6.2;

	private static float xMayBay = 4.0f, yMayBay = 2.0f , zMayBay = -4.0f;
	private static double rMayBay = 324.0;
	private static float xTuyet = 3.0f, yTuyet = -8.0f, zTuyet = -14.0f;
	private static double rTuyet = 0.0 , rCua = 0.0 , xNha2 = -1.2 , yNha2 = -1.5 , zNha2 = -1.25 ;

	private static double zLookAt = 12.0;
	private static double xLookAt = 0.0;
	private static double yLookAt = 0.5;

	private void myinit() throws IOException {

		myGL.glClearColor(0.0f, 1.0f, 1.0f, 0.0f);
 
		myGL.glShadeModel(GL.GL_FLAT); // Nhan be mat

		myGL.glEnable(GL.GL_DEPTH_TEST); // Bat den

		makeCheckImage();
		myGL.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 1); // Dua ra -> Luu trong bo nho

		myGL.glGenTextures(33, texName);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[0]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageCenter); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

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

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[17]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBefoter); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageCenterCanPhong); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh
		 
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRightCanPhong);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeftCanPhong); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageTopCanPhong);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[9]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBottomCanPhong);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[18]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBefoterCanPhong); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageCenterCanPhong2); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRightCanPhong2);
		 
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[12]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeftCanPhong2); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[13]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageTopCanPhong2);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[14]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBottomCanPhong2);
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[19]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBefoterCanPhong2); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[15]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRightNocNha);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[16]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeftNocNha); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh
		 

		//////////////////////////////////// Toa Tau
		//////////////////////////////////// //////////////////////////////////////////////

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[20]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageCenterToaTau); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[21]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRightToaTau);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[22]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeftToaTau); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[23]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageTopToaTau);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[24]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBottomToaTau);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[25]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBefoterToaTau); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[26]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imagetToaTau); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		//////////////////////////////////// Oto
		//////////////////////////////////// //////////////////////////////////////////////

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[27]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageCenterOto); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[28]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRightOto);
		
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[29]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeftOto); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[30]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageTopOto);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[31]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexEnvf(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_DECAL);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBottomOto);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[32]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBefoterOto); // value GL_UNSIGNED_BYTE -> Lay 8 bit
		// checkImage -> Hinh anh

		myGL.glEnable(GL.GL_TEXTURE_2D);
		// --------------------------------------------------//

	}

	public void display() {

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

		float xanhDam[] = { 0.0f, 0.5f, 1.0f, 0.0f };
		float xanh[] = { 0.0f, 1.0f, 0.0f, 0.0f };
		float daTroi[] = { 0.0f, 1.0f, 1.0f, 0.0f };
		float hong[] = { 0.5f, 0.5f, 0.5f, 0.0f };
		float tim[] = { 1.0f, 0.0f, 1.0f, 0.0f };
		float cam[] = { 0.5f, 0.5f, 0.0f, 0.0f };
		float trang[] = { 0.3f, 0.3f, 1.0f, 0.0f };
		float trangSang[] = { 0.6f, 1.0f, 1.0f, 0.0f };
		float den[] = { 0.0f, 0.0f, 0.0f, 0.0f };
		float Do[] = { 1.0f, 0.0f, 0.0f, 0.0f };
		
		float no_mat[] = { 0.0f, 0.0f, 0.0f, 1.0f };
		float mat_ambient[] = { 0.7f, 0.7f, 0.7f, 1.0f };
		float mat_diffuse[] = { 0.1f, 0.5f, 0.8f, 1.0f };
		float no_shininess[] = { 0.0f };
		float mat_emission[] = { 0.3f, 0.2f, 0.2f, 0.0f };

		// Non
		GLUquadricObj qobj;
		float non_specular[] = { 0.0f, 1.0f, 1.0f, 1.0f };
		// Non
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

		myGL.glMatrixMode(GL.GL_MODELVIEW);
		myGL.glLoadIdentity();

		myGLU.gluLookAt(xLookAt, yLookAt, zLookAt, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
		
		/**
	    0 : imageCenter ; 1 : imageRight ; 2 : imageLeft ; 3 : imageTop ; 4 : imageBottom ; 17 : imageBefoter -> KHUNG
	    5 : imageCenterCanPhong ; 6 : imageRightCanPhong ; 7 : imageLeftCanPhong ; 8 : imageTopCanPhong ; 9 : imageBottomCanPhong ; 18 : imageBefoterCanPhong  -> CAN PHONG TANG 1 
	    10 : imageCenterCanPhong2 ; 11 : imageRightCanPhong2 ; 12 : imageLeftCanPhong2 ; 13 : imageTopCanPhong2 ; 14 : imageBottomCanPhong2 ; 19 : imageBefoterCanPhong2 -> CAN PHONG TANG 2
	    15 : imageRightNocNha ; 16 : imageLeftNocNha ; -> NOC NHA 
	    20 : imageCenterToaTau ; 21: imageRightToaTau ; 22 : imageLeftToaTau ; 23: imageTopToaTau ; 24 : imageBottomToaTau ; 25 :imageBefoterToaTau  ; 26 :imagetToaTau ; -> TOA TAU 
	    27 : imageCenterOto ; 28 : imageRightOto; 29 : imageLeftOto ; 30 : imageTopOto ; 31 : imageBottomOto ; 32 : imageBefoterOto ; -> O TO CON
	    
	 */
		
		// -----------------------KhongGian-------------------------------------//
		myGL.glPushMatrix();
		myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glTranslated(xkhonggian, ykhonggian, t);
		myGL.glRotatef(r, 0.0f, 1.0f, 0.0f);
		myGL.glScaled(11.0, 6.0, 10.0);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[0]); // texName [0] -> checkImage
		myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(2.0f, -2.0f, -2.0f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[1]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(2.0f, -2.0f, -2.0f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[2]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(-2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(-2.0f, -2.0f, -2.0f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[3]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(2.0f, 2.0f, 2.0f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[4]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(2.0f, -2.0f, 2.0f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[17]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(2.0f, -2.0f, 2.0f);
		myGL.glEnd();

		//------------------- CAN PHONG TANG 1 ---------------------------//
		
		myGL.glTranslated(-1.2, -1.5, -1.25);
		myGL.glRotatef(rNha, 0.0f, 1.0f, 0.0f);
		myGL.glScaled(1.5, 1.75, 1.75);
//		myGL.glScaled(1.25, 1.5, 1.25);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]); // texName [0] -> checkImage
		myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[9]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[18]);
		myGL.glPushMatrix();
		myGL.glRotated(rCua, 0.0, 1.0, 0.0);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glEnd();
		myGL.glPopMatrix();
		
		// -----------------GAU-------------------------------//
				myGL.glPushMatrix();

				myGL.glDisable(GL.GL_TEXTURE_2D);
				myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
				myGL.glDepthFunc(GL.GL_LESS);
				myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
				myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

				myGL.glTranslatef(-0.1f, -1.2f, 0.0f);
				myGL.glRotated(rTuyet, 0.0, 1.0, 0.0);
				myGL.glTranslatef(0.0f, 1.0f, 0.0f);

				myGL.glScalef(0.2f, 0.2f, 0.2f);

				// TO GAU
//						myGL.glScalef(0.5f, 0.5f, 0.5f);
						
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR,xanh); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myUT.glutSolidSphere(0.3f, 10, 8);
				myGL.glPopMatrix();

				myGL.glTranslatef(0.0f, 0.3f, 0.0f);

				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myUT.glutSolidSphere(0.2f, 10, 8);
				myGL.glPopMatrix();

				myGL.glTranslatef(-0.3f, -0.2f, 0.0f);

				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myUT.glutSolidSphere(0.1f, 10, 8);
				myGL.glPopMatrix();

				myGL.glTranslatef(0.6f, 0.0f, 0.0f);

				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myUT.glutSolidSphere(0.1f, 10, 8);
				myGL.glPopMatrix();

				myGL.glTranslatef(-0.1f, -0.3f, 0.1f);

				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myUT.glutSolidSphere(0.1f, 10, 8);
				myGL.glPopMatrix();

				myGL.glTranslatef(-0.4f, 0.0f, 0.0f);

				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myUT.glutSolidSphere(0.1f, 10, 8);
				myGL.glPopMatrix();

				myGL.glTranslatef(0.27f, 0.55f, 0.05f);

				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, den); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myUT.glutSolidSphere(0.05f, 10, 8);
				myGL.glPopMatrix();

				myGL.glTranslatef(-0.2f, 0.0f, -0.05f);

				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, den); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myUT.glutSolidSphere(0.05f, 10, 8);
				myGL.glPopMatrix();

				myGL.glTranslatef(0.1f, -0.05f, 0.08f);

				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myUT.glutSolidSphere(0.05f, 10, 8);
				myGL.glPopMatrix();

				myGL.glTranslatef(0.1f, 0.2f, -0.2f);

				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myUT.glutSolidSphere(0.15f, 10, 8);
				myGL.glPopMatrix();

				myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
				myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8
				myGL.glEnable(GL.GL_TEXTURE_2D);

				myGL.glPopMatrix();

				// ----------------- BAN GHE -------------------------------//
				myGL.glPushMatrix();

				
				myGL.glDisable(GL.GL_TEXTURE_2D);
				myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
				myGL.glDepthFunc(GL.GL_LESS);
				myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
				myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
		 
				myGL.glTranslatef(0.2f, -0.1f, 0.0f);
				myGL.glRotated(-90, 0.0, 1.0, 0.0);
				myGL.glScalef(0.06f, 0.1f, 0.06f);
				
				for ( int i = 0 ; i < 3 ; i ++) {
//					myGL.glTranslatef(0.0f, -0.5f, 0.0f);
				if ( i == 1 ) {
					myGL.glRotated(180, 1.0, 0.0, 0.0);
					myGL.glTranslatef(1.0f, 0.6f, -0.7f);
				}
				if ( i == 2 ) {
					myGL.glRotated(180, 1.0, 0.0, 0.0);
					myGL.glTranslatef(1.0f, 0.6f, -0.7f);
				}
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR,xanh); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(1.0f, 1.0f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();

				myGL.glTranslatef(0.0f, -0.30f, 0.30f);
				myGL.glRotated(90, 1.0, 0.0, 0.0);
				
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(1.0f, 1.0f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();
				
				myGL.glTranslatef(0.3f, -0.30f, 0.30f);
				myGL.glRotated(90, 1.0, 0.0, 0.0);
				
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(0.2f, 0.7f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();
				
				myGL.glTranslatef(-0.7f, 0.0f, 0.0f); 
				
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(0.2f, 0.7f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();
				
				myGL.glTranslatef(0.0f, 0.0f, -0.7f); 
				
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(0.2f, 0.7f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();
				
				myGL.glTranslatef(0.7f, 0.0f, 0.0f); 
				
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(0.2f, 0.7f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();

				}

				myGL.glTranslatef(-1.5f, -0.30f, -1.0f);
				myGL.glRotated(-90, 1.0, 0.0, 0.0);
				myGL.glScalef(3.0f, 1.5f, 1.5f);
				
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Do); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(1.5f, 1.0f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();
				
				myGL.glTranslatef(0.3f, -0.30f, 0.30f);
				myGL.glRotated(90, 1.0, 0.0, 0.0);
				
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(0.2f, 0.7f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();
				
				myGL.glTranslatef(-0.7f, 0.0f, 0.0f); 
				
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(0.2f, 0.7f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();
				
				myGL.glTranslatef(0.0f, 0.0f, -0.7f); 
				
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(0.2f, 0.7f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();
				
				myGL.glTranslatef(0.7f, 0.0f, 0.0f); 
				
				myGL.glPushMatrix();
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
				myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
				myGL.glScalef(0.2f, 0.7f, 0.2f);
				myUT.glutSolidCube(1);
				myGL.glPopMatrix();
				
				myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
				myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8
				myGL.glEnable(GL.GL_TEXTURE_2D);

				myGL.glPopMatrix();

				//=====================================================// 
				
		//----------------- CAN PHONG TANG 2 --------------------------//
				
		myGL.glTranslated(0.0, 0.568, 0.0); 
		myGL.glScaled(1.0, 1.25, 1.0);

 
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]); // texName [0] -> checkImage
		myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[12]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[13]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[14]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[19]);
		myGL.glPushMatrix();
		myGL.glRotated(-rCua, 0.0, 1.0, 0.0);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glEnd();
		myGL.glPopMatrix();

		// -----------------BAN GHE-------------------------------//
		myGL.glPushMatrix();

		
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
		myGL.glDepthFunc(GL.GL_LESS);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8
 
		myGL.glTranslatef(0.2f, -0.1f, 0.0f);
		myGL.glRotated(-90, 0.0, 1.0, 0.0);
		myGL.glScalef(0.06f, 0.1f, 0.06f);
		
		for ( int i = 0 ; i < 3 ; i ++) {
//			myGL.glTranslatef(0.0f, -0.5f, 0.0f);
		if ( i == 1 ) {
			myGL.glRotated(180, 1.0, 0.0, 0.0);
			myGL.glTranslatef(1.0f, 0.6f, -0.7f);
		}
		if ( i == 2 ) {
			myGL.glRotated(180, 1.0, 0.0, 0.0);
			myGL.glTranslatef(1.0f, 0.6f, -0.7f);
		}
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR,xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(1.0f, 1.0f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, -0.30f, 0.30f);
		myGL.glRotated(90, 1.0, 0.0, 0.0);
		
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(1.0f, 1.0f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		
		myGL.glTranslatef(0.3f, -0.30f, 0.30f);
		myGL.glRotated(90, 1.0, 0.0, 0.0);
		
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.2f, 0.7f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		
		myGL.glTranslatef(-0.7f, 0.0f, 0.0f); 
		
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.2f, 0.7f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		
		myGL.glTranslatef(0.0f, 0.0f, -0.7f); 
		
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.2f, 0.7f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		
		myGL.glTranslatef(0.7f, 0.0f, 0.0f); 
		
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.2f, 0.7f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		}

		for ( int j = 0 ; j < 2 ; j ++) {
		myGL.glTranslatef(-1.5f, -0.30f, -1.0f);
		myGL.glRotated(-90, 1.0, 0.0, 0.0);
		myGL.glScalef(3.0f, 1.5f, 1.5f);
		
		if ( j == 1 ) {
			myGL.glTranslatef(0.3f, 0.6f, 0.2f); 
			myGL.glScalef(0.4f, 0.9f, 0.5f);
//			myGL.glRotated(-90, 1.0, 0.0, 0.0);
		}
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Do); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(1.5f, 1.0f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		
		myGL.glTranslatef(0.3f, -0.30f, 0.30f);
		myGL.glRotated(90, 1.0, 0.0, 0.0);
		
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.2f, 0.7f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		
		myGL.glTranslatef(-0.7f, 0.0f, 0.0f); 
		
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.2f, 0.7f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		
		myGL.glTranslatef(0.0f, 0.0f, -0.7f); 
		
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.2f, 0.7f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		
		myGL.glTranslatef(0.7f, 0.0f, 0.0f); 
		
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cam); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.2f, 0.7f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		}
		
		myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8
		myGL.glEnable(GL.GL_TEXTURE_2D);

		////////////////////////////////////////////////////////////
		//--------------------NHA THU 2------------------------------//
				myGL.glPushMatrix();
				myGL.glTranslated(0.75, -1.0, 7.0); 
//				myGL.glTranslated(xNha2, yNha2, zNha2); 
				myGL.glRotatef(180, 1.0f, 0.0f, 0.0f);
				myGL.glScaled(1.5, 2.5, 3.0); 

				// NHO NHA THU 2 
//						myGL.glScalef(2.0f, 2.0f, 2.0f);
						
				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]); // texName [0] -> checkImage
				myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
				myGL.glTexCoord2f(0.0f, 0.0f);
				myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);
				myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);
				myGL.glVertex3f(0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);
				myGL.glVertex3f(0.25f, -0.25f, -0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);
				myGL.glVertex3f(0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);
				myGL.glVertex3f(0.25f, 0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);
				myGL.glVertex3f(0.25f, -0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);
				myGL.glVertex3f(0.25f, -0.25f, -0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, 0.25f, 0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[9]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, -0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, -0.25f, 0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[18]);
				myGL.glPushMatrix();
//				myGL.glRotated(rCua, 0.0, 1.0, 0.0);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, 0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, -0.25f, 0.25f);
				myGL.glEnd();
				myGL.glPopMatrix();
				
				// -----------------GAU-------------------------------//
						myGL.glPushMatrix();

						myGL.glDisable(GL.GL_TEXTURE_2D);
						myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
						myGL.glDepthFunc(GL.GL_LESS);
						myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
						myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

						myGL.glTranslatef(0.0f, -1.2f, -0.2f);
						myGL.glRotated(rTuyet, 0.0, 1.0, 0.0);
						myGL.glTranslatef(0.0f, 1.0f, 0.0f);

						myGL.glScalef(0.1f, 0.1f, 0.1f);

						myGL.glPushMatrix();
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR,xanh); // khong hien thi mau
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
						myUT.glutSolidSphere(0.3f, 10, 8);
						myGL.glPopMatrix();

						myGL.glTranslatef(0.0f, 0.3f, 0.0f);

						myGL.glPushMatrix();
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
						myUT.glutSolidSphere(0.2f, 10, 8);
						myGL.glPopMatrix();

						myGL.glTranslatef(-0.3f, -0.2f, 0.0f);

						myGL.glPushMatrix();
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
						myUT.glutSolidSphere(0.1f, 10, 8);
						myGL.glPopMatrix();

						myGL.glTranslatef(0.6f, 0.0f, 0.0f);

						myGL.glPushMatrix();
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
						myUT.glutSolidSphere(0.1f, 10, 8);
						myGL.glPopMatrix();

						myGL.glTranslatef(-0.1f, -0.3f, 0.1f);

						myGL.glPushMatrix();
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
						myUT.glutSolidSphere(0.1f, 10, 8);
						myGL.glPopMatrix();

						myGL.glTranslatef(-0.4f, 0.0f, 0.0f);

						myGL.glPushMatrix();
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
						myUT.glutSolidSphere(0.1f, 10, 8);
						myGL.glPopMatrix();

						myGL.glTranslatef(0.27f, 0.55f, 0.05f);

						myGL.glPushMatrix();
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, den); // khong hien thi mau
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
						myUT.glutSolidSphere(0.05f, 10, 8);
						myGL.glPopMatrix();

						myGL.glTranslatef(-0.2f, 0.0f, -0.05f);

						myGL.glPushMatrix();
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, den); // khong hien thi mau
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
						myUT.glutSolidSphere(0.05f, 10, 8);
						myGL.glPopMatrix();

						myGL.glTranslatef(0.1f, -0.05f, 0.08f);

						myGL.glPushMatrix();
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
						myUT.glutSolidSphere(0.05f, 10, 8);
						myGL.glPopMatrix();

						myGL.glTranslatef(0.1f, 0.2f, -0.2f);

						myGL.glPushMatrix();
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
						myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
						myUT.glutSolidSphere(0.15f, 10, 8);
						myGL.glPopMatrix();

						myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
						myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8
						myGL.glEnable(GL.GL_TEXTURE_2D);

						myGL.glPopMatrix();

				myGL.glTranslated(0.0, 0.568, 0.0);
//				myGL.glRotatef(r, 0.0f, 1.0f, 0.0f);
				myGL.glScaled(1.0, 1.25, 1.0);

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]); // texName [0] -> checkImage
				myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
				myGL.glTexCoord2f(0.0f, 0.0f);
				myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);
				myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);
				myGL.glVertex3f(0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);
				myGL.glVertex3f(0.25f, -0.25f, -0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[11]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);
				myGL.glVertex3f(0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);
				myGL.glVertex3f(0.25f, 0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);
				myGL.glVertex3f(0.25f, -0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);
				myGL.glVertex3f(0.25f, -0.25f, -0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[12]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);
				myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);
				myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);
				myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);
				myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[13]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);
				myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);
				myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);
				myGL.glVertex3f(0.25f, 0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);
				myGL.glVertex3f(0.25f, 0.25f, 0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[14]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);
				myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);
				myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);
				myGL.glVertex3f(0.25f, -0.25f, -0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);
				myGL.glVertex3f(0.25f, -0.25f, 0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[19]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);
				myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);
				myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);
				myGL.glVertex3f(0.25f, 0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);
				myGL.glVertex3f(0.25f, -0.25f, 0.25f);
				myGL.glEnd();

				myGL.glTranslated(0.0, 0.3, 0.0); 
				myGL.glScaled(1.0, 0.8, 1.0);

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[15]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);
				myGL.glVertex3f(0.0f, 0.25f, -0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);
				myGL.glVertex3f(0.0f, 0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);
				myGL.glVertex3f(0.45f, -0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);
				myGL.glVertex3f(0.45f, -0.25f, -0.25f);
				myGL.glEnd();

				myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[16]);
				myGL.glBegin(GL.GL_QUADS);
				myGL.glTexCoord2f(0.0f, 0.0f);
				myGL.glVertex3f(0.0f, 0.25f, -0.25f);
				myGL.glTexCoord2f(0.0f, 1.0f);
				myGL.glVertex3f(0.0f, 0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 1.0f);
				myGL.glVertex3f(-0.45f, -0.25f, 0.25f);
				myGL.glTexCoord2f(1.0f, 0.0f);
				myGL.glVertex3f(-0.45f, -0.25f, -0.25f);
				myGL.glEnd();
				myGL.glPopMatrix();
				
				//================================================//
				
		myGL.glPopMatrix();

		//=====================NHA ================================// 
		
		//------------------- NOC NHA ----------------------------//
		myGL.glTranslated(0.0, 0.3, 0.0);
//		myGL.glRotatef(r, 0.0f, 1.0f, 0.0f);
		myGL.glScaled(1.0, 0.8, 1.0);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[15]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(0.0f, 0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(0.0f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.45f, -0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.45f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[16]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.0f, 0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.0f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-0.45f, -0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-0.45f, -0.25f, -0.25f);
		myGL.glEnd();

		//=====================================================================//
		
		//==================== TOA TAU =======================================//

//		myGL.glTranslated(-1.5, -0.2, 1.2); 
		myGL.glTranslated(xt, yt -0.2, zt - 1.0);
		myGL.glRotatef(135, 0.0f, 1.0f, 0.0f);
		myGL.glScaled(1.25, 0.5, 0.25);

		// NHO MAY BAY 2 
//		        myGL.glTranslated(xt, yt , zt - 0.5);
//				myGL.glScalef(0.5f, 0.5f, 0.5f);
				
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[20]); // texName [0] -> checkImage
		myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[21]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[22]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[23]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[24]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[25]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glEnd();

		myGL.glTranslated(1.3, -1.25, 8.0); 
		myGL.glScaled(10, 0.5, 1.0);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[26]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glEnd();
		
		myGL.glEnable(GL.GL_TEXTURE_2D);


		myGL.glPopMatrix();

//		myGL.glBegin(GL.GL_LINES);
//		myGL.glColor3f(0.0f, 1.0f, 1.0f);
//
//		myGL.glVertex3f(-5.0f, 0.0f, 0.0f);
//		myGL.glVertex3f(5.0f, 0.0f, 0.0f);
//		myGL.glEnd();
//
//		myGL.glBegin(GL.GL_LINES);
//		myGL.glColor3f(0.0f, 1.0f, 1.0f);
//
//		myGL.glVertex3f(0.0f, -5.0f, 0.0f);
//		myGL.glVertex3f(0.0f, 5.0f, 0.0f);
//		myGL.glEnd();

		// -----------------------------------------------------------//

//		myGL.glPushMatrix(); 
		myGL.glPushMatrix();
		// -------------------------------------------------------------//
		myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
		myGL.glDepthFunc(GL.GL_LESS);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glDisable(GL.GL_TEXTURE_2D);

		// Nho robot
		myGL.glScalef(x2 + 1.0f, y2 + 1.0f , z2 + 1.0f);
//		myGL.glScalef(2.0f, 1.0f, 0.15f);
 
		// Than

		myGL.glTranslatef(tx, ty, -6.0f);
		myGL.glRotatef((float) shoulderX, x1, y1, z1);
		myGL.glTranslatef(tqx, tqy, 0.0f);

		myGL.glPushMatrix();

		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Than_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, Than_shininess); // khong ve mau bao trum
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambient);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_diffuse);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_EMISSION, mat_emission);
//		disPlay ();
		myGL.glScalef(1.0f, 1.0f, 0.5f);
		myUT.glutSolidCube(1);

		// Cánh tay trai

		myGL.glPushMatrix();
		//
		myGL.glTranslatef(0.75f, 0.5f, 0.0f);
		myGL.glRotatef((float) shoulderTT, x1, y1, z1);
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
		myUT.glutSolidSphere(0.2f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) elbowTT, x1, y1, z1);
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
		myUT.glutSolidSphere(0.2f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glPopMatrix();

		// Cánh tay phai

		myGL.glPushMatrix();

		myGL.glTranslatef(-0.75f, 0.5f, 0.0f);
		myGL.glRotatef((float) shoulderTP, x1, y1, z1);
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
		myUT.glutSolidSphere(0.2f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) elbowTP, x1, y1, z1);
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
		myUT.glutSolidSphere(0.2f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glPopMatrix();
		// ---------------------//

		myGL.glPopMatrix();
		// -------------------//
		// -------------------------//

		// Chan
		myGL.glPushMatrix();
		myGL.glTranslatef(tcx, tcy, 0.0f);
		myGL.glRotatef((float) shoulderXC, x1, y1, z1);
		myGL.glTranslatef(tqcx, tqcy, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, Than_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, chan_specular); // khong ve mau bao trum
		myGL.glScalef(0.25f, 0.2f, 0.2f);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
//		myUT.glutSolidSphere(0.5f, 10, 8);

		// ------------------------//

		// Dau

		myGL.glTranslated(0.0f, 0.5f, 0.0f); // Dich chuyen hinh lai cho cu
		myGL.glRotatef((float) shoulderXD, x1, y1, z1);
		myGL.glTranslated(0.0f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.5f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslated(-0.19f, 0.0f, 0.39f); // Dich chuyen hinh lai cho cu
		myGL.glRotatef((float) shoulderXD, x1, y1, z1);
		myGL.glTranslated(0.0f, 0.0f, 0.0f);

//		myGL.glColor3f(1.0f, 1.0f, 1.0f);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, boPhanMat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, boPhanMat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslated(0.19f, 0.0f, 0.39f); // Dich chuyen hinh lai cho cu
		myGL.glRotatef((float) shoulderXD, x1, y1, z1);
		myGL.glTranslated(0.0f, 0.0f, 0.0f);

//		myGL.glColor3f(1.0f, 1.0f, 1.0f);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, boPhanMat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, boPhanMat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glTranslated(0.0f, -0.2f, 0.39f); // Dich chuyen hinh lai cho cu
		myGL.glRotatef((float) shoulderXD, x1, y1, z1);
		myGL.glTranslated(0.0f, 0.0f, 0.0f);

//		myGL.glColor3f(1.0f, 0.0f, 0.0f);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mieng_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mieng_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1f, 10, 8); /* vẽ hình tròn */

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
//		myGL.glMaterialfv (GL.GL_FRONT, GL.GL_AMBIENT, mat_ambient);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, non_specular);
		myGL.glRotatef(270.0f, 2.0f, 0.0f, 0.0f);
		myGL.glCallList(startList + 1);
		myGL.glPopMatrix();

		myGL.glPopMatrix();

		myGL.glPopMatrix();

		// ---------------------------------------------------//
//		myGL.glPopMatrix();

		// Canh chan trai
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
		myUT.glutSolidSphere(0.2f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) elbowCT, x11, y11, z11);
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

		// Canh chan phai
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
		myUT.glutSolidSphere(0.2f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.0f, 0.0f);
		myGL.glRotatef((float) elbowCP, x11, y11, z11);
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
		// -------------------------//

		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();

		// ------------------BONG BONG---------------------------------//

		myGL.glPushMatrix();

		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
		myGL.glDepthFunc(GL.GL_LESS);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glTranslatef(5.0f, yb, -4.0f);
		myGL.glRotatef((float) 0, 0.0f, 1.0f, 0.0f);
		myGL.glTranslatef(0.0f, 3.0f, 0.0f);


		// NHO BONG BONG
//				myGL.glScalef(0.5f, 0.5f, 0.5f);
				
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, cachTay_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.2f, 0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_specular); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.2f, 0.5f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.6f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.6f, -0.2f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanhDam); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.5f, -0.4f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, hong); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.5f, -0.4f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.6f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.6f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glColor3f(1.0f, 0.0f, 0.0f);
//		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh ); // khong hien thi mau
//		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.1f, 0.5f, 0.1f);
		myUT.glutSolidSphere(0.1f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glPopMatrix();

		// --------------MAY BAY-------------------------------------//
		myGL.glPushMatrix();

		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
		myGL.glDepthFunc(GL.GL_LESS);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glTranslatef(xMayBay   , yMayBay , zMayBay  );
		myGL.glRotated(rMayBay, 1.0, 0.0, 0.0);
		myGL.glTranslatef(-2.0f, 4.0f, 2.0f);

		// NHO MAY BAY
//				myGL.glScalef(0.5f, 0.5f, 0.5f);
				
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(3.5f, 0.6f, 0.6f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.5f, -0.3f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, daTroi); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 1.5f, 1.0f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.6f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, daTroi); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 1.5f, 1.0f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(1.25f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, daTroi); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 0.7f, 0.7f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		// -----------------MAY BAY 2-------------------------//
		myGL.glTranslatef(-3.0f, 1.0f, 0.0f);

		// NHO MAY BAY 2 
//				myGL.glScalef(0.5f, 0.5f, 0.5f);
				
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, xanh); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(3.5f, 0.6f, 0.6f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.5f, -0.3f, 0.0f);
				
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 1.5f, 1.0f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.6f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 1.5f, 1.0f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glTranslatef(1.25f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myGL.glScalef(0.5f, 0.7f, 0.7f);
		myUT.glutSolidSphere(0.4f, 10, 8); /* vẽ hình tròn */
		myGL.glPopMatrix();

		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glPopMatrix();
		// ---------------------------------------------------//

		// -----------------GAU-------------------------------//
		myGL.glPushMatrix();

		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glShadeModel(GL.GL_SMOOTH); // Nhan be mat
		myGL.glDepthFunc(GL.GL_LESS);
		myGL.glEnable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glEnable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glTranslatef(xTuyet, yTuyet, zTuyet);
		myGL.glRotated(rTuyet, 0.0, 1.0, 0.0);
		myGL.glTranslatef(0.0f, 1.0f, 0.0f);

		myGL.glScalef(3.5f, 3.5f, 3.5f);

		// NHO GAU
//				myGL.glScalef(2.0f, 2.0f, 2.0f);
				
		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.3f, 10, 8);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.0f, 0.3f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.2f, 10, 8);
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.3f, -0.2f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1f, 10, 8);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.6f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1f, 10, 8);
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.1f, -0.3f, 0.1f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1f, 10, 8);
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.4f, 0.0f, 0.0f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trangSang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.1f, 10, 8);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.27f, 0.55f, 0.05f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, den); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.05f, 10, 8);
		myGL.glPopMatrix();

		myGL.glTranslatef(-0.2f, 0.0f, -0.05f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, den); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.05f, 10, 8);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.1f, -0.05f, 0.08f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, tim); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.05f, 10, 8);
		myGL.glPopMatrix();

		myGL.glTranslatef(0.1f, 0.2f, -0.2f);

		myGL.glPushMatrix();
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, trang); // khong hien thi mau
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess); // khong ve mau bao trum
		myUT.glutSolidSphere(0.15f, 10, 8);
		myGL.glPopMatrix();

		myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8
		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glPopMatrix();
		 
        // ====================== OTO ==================================//
		myGL.glPushMatrix();
		myGL.glTranslated(xOto + 2.0, yOto, zOto);
		myGL.glRotatef(10, 0.0f, 1.0f, 0.0f);
		myGL.glScaled(8.0, 6.0, 6.0);
		 

		// NHO O TO
//				myGL.glScalef(0.5f, 0.5f, 0.5f);
				
		myGL.glDisable(GL.GL_LIGHTING); // Bat anh sang chieu mat_specular chieu Mau
		myGL.glDisable(GL.GL_LIGHT0); // Bat den 1 .. 8

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[27]); // texName [0] -> checkImage
		myGL.glBegin(GL.GL_QUADS); // Hinh chu nhat -> hoi tu
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[28]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[29]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);	myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[30]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, 0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[31]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, -0.25f, -0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[32]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);myGL.glVertex3f(-0.25f, -0.25f, 0.25f);
		myGL.glTexCoord2f(0.0f, 1.0f);myGL.glVertex3f(-0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 1.0f);myGL.glVertex3f(0.25f, 0.25f, 0.25f);
		myGL.glTexCoord2f(1.0f, 0.0f);myGL.glVertex3f(0.25f, -0.25f, 0.25f);
		myGL.glEnd();

		myGL.glEnable(GL.GL_TEXTURE_2D);
		myGL.glPopMatrix();
		
		//--------------------NHA THU 2------------------------------//
		
		 
//		myGL.glPopMatrix();
		myGL.glFlush();
	}

	public void myReshape(int w, int h) {
		myGL.glViewport(0, 0, w, h);
		myGL.glMatrixMode(GL.GL_PROJECTION);
		myGL.glLoadIdentity();
		myGLU.gluPerspective(60.0f, 1.0 * (double) w / (double) h, 1.0, 50.0); 
	}

	public void spinDisplay() {
		x11 = 1.0f;
		shoulderCT = (shoulderCT - 4) % 45;
		shoulderCP = (shoulderCP - 4) % 60;
		elbowCT = (elbowCT + 4) % 90;
		elbowCP = (elbowCP + 4) % 90;

		x1 = 1.0f;
		shoulderTT = (shoulderTT - 4) % 45;
		shoulderTP = (shoulderTP - 4) % 60;
		elbowTT = (elbowTT + 4) % 90;
		elbowTP = (elbowTP + 4) % 90;

		x2 = x2 + 0.05f;
		y2 = y2 + 0.05f;
		z2 = z2 + 0.05f;
		myUT.glutPostRedisplay();
	}

	public void DiLui() {
		x11 = 1.0f;
		shoulderCT = (shoulderCT - 4) % 45;
		shoulderCP = (shoulderCP - 4) % 60;
		elbowCT = (elbowCT + 4) % 90;
		elbowCP = (elbowCP + 4) % 90;

		x1 = 1.0f;
		shoulderTT = (shoulderTT - 4) % 45;
		shoulderTP = (shoulderTP - 4) % 60;
		elbowTT = (elbowTT + 4) % 90;
		elbowTP = (elbowTP + 4) % 90;

		x2 = x2 - 0.01f;
		y2 = y2 - 0.01f;
		z2 = z2 - 0.01f;
		myUT.glutPostRedisplay();
	}

	public void quayVongQuanh() {
		y1 = 1.0f;
		tqy = 1.0f;
		tqx = 2.0f;
		shoulderX = (shoulderX - 4) % 360;
//		System.out.println(shoulderX);

		x11 = 1.0f;
		shoulderCT = (shoulderCT - 4) % 45;
		shoulderCP = (shoulderCP - 4) % 60;
		x11 = 1.0f;
		elbowCT = (elbowCT + 4) % 90;
		elbowCP = (elbowCP + 4) % 90;

		myUT.glutPostRedisplay();
		if (shoulderX < -180) {
			x11 = 1.0f;
			shoulderCT = (shoulderCT - 4) % 45;
			shoulderCP = (shoulderCP - 4) % 60;
			elbowCT = (elbowCT + 4) % 90;
			elbowCP = (elbowCP + 4) % 90;

			x2 = x2 + 0.01f;
			y2 = y2 + 0.01f;
			z2 = z2 + 0.01f;
			myUT.glutPostRedisplay();
		}

	}

	/* ARGSUSED2 */
	public void mouse(int button, int state, int x, int y) {
		if (button == GLUT.GLUT_LEFT_BUTTON) {
			if (state == GLUT.GLUT_DOWN) {
				myUT.glutIdleFunc("quayVongQuanh");
			}
		} else if (button == GLUT.GLUT_MIDDLE_BUTTON) { // Di ve phia truoc
			if (state == GLUT.GLUT_DOWN) {
				myUT.glutIdleFunc("spinDisplay");
			}
		}
	}

//	/* ARGSUSED1 */
	public void keyboard(char key, int x, int y) {
		switch (key) {
		case 'v': // Khong gian 
			t = t + 1.0 ;
			yb = yb + 0.2f ;
			yMayBay = yMayBay + 0.2f ;
			rCua = ( rCua + 3.0 )  ;
			zNha2 = zNha2 + 1.0 ;
			myUT.glutPostRedisplay();
			break;
		case 'a': // Khong gian
			zTuyet = zTuyet + 1.0f;
			myUT.glutPostRedisplay();
			break;
		case 'V': 
			t = t - 1.0 ;
			yb = yb + 0.2f ;
			yMayBay = yMayBay + 0.2f ;
			zNha2 = zNha2 - 1.0 ;
			myUT.glutPostRedisplay();
			break;
		case 'y': 
			ykhonggian = ykhonggian - 2.0;
			myUT.glutPostRedisplay();
			break;
		case 'Y': 
			ykhonggian = ykhonggian + 2.0;
			myUT.glutPostRedisplay();
			break;
		case 'z': // Chay Tau
			xt = xt + 0.1;
			zt = zt + 0.1;
			yb = yb + 0.1f;
			xMayBay = xMayBay - 0.2f;
			zMayBay = zMayBay + 0.1f;
			zTuyet = zTuyet + 0.2f;
			// ----------//
			x11 = 1.0f;
			shoulderCT = (shoulderCT - 4) % 45;
			shoulderCP = (shoulderCP - 4) % 60;
			elbowCT = (elbowCT + 4) % 90;
			elbowCP = (elbowCP + 4) % 90;

			x1 = 1.0f;
			shoulderTT = (shoulderTT - 4) % 45;
			shoulderTP = (shoulderTP - 4) % 60;
			elbowTT = (elbowTT + 4) % 90;
			elbowTP = (elbowTP + 4) % 90;

			x2 = x2 + 0.01f;
			y2 = y2 + 0.02f;
//			z2 = z2 + 0.05f;
			//-----------//
			xOto = xOto - 0.7 ;
			zOto = zOto + 0.5 ;
			myUT.glutPostRedisplay();
			break;
		case 'm': // Chay Tau
			rTuyet = (rTuyet + 4) % 360;
			myUT.glutPostRedisplay();
			break;
		case 'O': // Khong gian
			r = (r + 4) % 360;
			xTuyet = xTuyet - 2.0f ;
			tx = tx - 1.0f ;
			yb = yb + 0.2f ;
			yMayBay = yMayBay + 0.2f ;
			xNha2 = xNha2 - 0.55 ;
			myUT.glutPostRedisplay();
			break;
		case 'o':
			r = (r - 4) % 360;
			xTuyet = xTuyet + 2.0f ;
			tx = tx + 1.0f ;
			yb = yb + 0.2f ;
			yMayBay = yMayBay + 0.2f ;
			xNha2 = xNha2 + 0.55 ;
			myUT.glutPostRedisplay();
			break;
		case 'i': // Khong gian
			rNha = (rNha + 4) % 360;
			myUT.glutPostRedisplay();
			break;
		case 'I':
			rNha = (rNha - 4) % 360;
			myUT.glutPostRedisplay();
			break;
		case 'r':
//			r = (r + 4) % 360;
			xkhonggian = xkhonggian + 1.0;
			myUT.glutPostRedisplay();
			break;
		case 'l':
//			r = (r + 4) % 360;
			xkhonggian = xkhonggian - 1.0;
			myUT.glutPostRedisplay();
			break;
		case 't':  
			ykhonggian = ykhonggian + 2.0; 
			yb = yb + 0.2f ;
			yMayBay = yMayBay + 0.2f ;
			yNha2 = yNha2 + 0.05 ;
			myUT.glutPostRedisplay();
			break;
		case 'T': 
			ykhonggian = ykhonggian - 2.0;

			yb = yb + 0.2f ;
			yMayBay = yMayBay + 0.2f ;
			yNha2 = yNha2 - 0.05 ;
			myUT.glutPostRedisplay();
			break; 
		case 's':
			y1 = 1.0f;
			shoulderX = (shoulderX + 4) % 360;
			myUT.glutPostRedisplay();
			break;
		case 'S':
			y1 = 1.0f;
			shoulderX = (shoulderX - 4) % 360;
			myUT.glutPostRedisplay();
			break;
		case 'k': // chao
			z1 = 1.0f;
			ct = 0.5f;
			shoulderTT = (shoulderTT - 2) % 45;
			elbowTT = (elbowTT - 2) % 60;
			shoulderTP = (shoulderTP + 2) % 45;
			elbowTP = (elbowTP + 2) % 60;
			myUT.glutPostRedisplay();
			break;
		case 'g': // Gat dau
			x1 = 1.0f;
			shoulderXC = (shoulderXC + 4) % 45;
			myUT.glutPostRedisplay();
			break;
		case 'X': // Cui Chao
			x1 = 1.0f;
			shoulderX = (shoulderX + 2) % 45;

			x11 = 1.0f;
			shoulderCP = (shoulderCP - 2) % 45;
			shoulderCT = (shoulderCT - 2) % 45;
			myUT.glutPostRedisplay();
			break;

		case 'D': // Di lui ve phia sau
			x11 = 1.0f;
			shoulderCT = (shoulderCT - 4) % 45;
			shoulderCP = (shoulderCP - 4) % 60;
			elbowCT = (elbowCT + 4) % 90;
			elbowCP = (elbowCP + 4) % 90;

			x1 = 1.0f;
			shoulderTT = (shoulderTT - 4) % 45;
			shoulderTP = (shoulderTP - 4) % 60;
			elbowTT = (elbowTT + 4) % 90;
			elbowTP = (elbowTP + 4) % 90;

			x2 = x2 - 0.05f;
			y2 = y2 - 0.05f;
			z2 = z2 - 0.05f;
			myUT.glutPostRedisplay();
			break;

		case 'e': // Xoay tay
			z1 = 1.0f;
			elbowTT = (elbowTT + 5) % 360;
			elbowTP = (elbowTP + 5) % 360;
			myUT.glutPostRedisplay();
			break;

		case 'n': // Nhay
			x11 = 1.0f;
			shoulderCT = (shoulderCT - 4) % 45;
			shoulderCP = (shoulderCP - 4) % 45;
			elbowCT = (elbowCT + 4) % 90;
			elbowCP = (elbowCP + 4) % 90;

			ty = 0.1f;
			z1 = 1.0f;
			shoulderTT = (shoulderTT + 4) % 45;
			shoulderTP = (shoulderTP - 4) % 45;

			myUT.glutPostRedisplay();

			break;
		case 'N': // Nhay
			x11 = 1.0f;
			shoulderCT = (shoulderCT - 4) % 45;
			shoulderCP = (shoulderCP - 4) % 45;
			elbowCT = (elbowCT + 4) % 90;
			elbowCP = (elbowCP + 4) % 90;

			ty = -3.0f;
			z1 = 1.0f;
			shoulderTT = (shoulderTT + 4) % 45;
			shoulderTP = (shoulderTP - 4) % 45;

			myUT.glutPostRedisplay();

			break;
		case 'd': // Di ve phia truoc
			x11 = 1.0f;
			shoulderCT = (shoulderCT - 4) % 45;
			shoulderCP = (shoulderCP - 4) % 60;
			elbowCT = (elbowCT + 4) % 90;
			elbowCP = (elbowCP + 4) % 90;

			x1 = 1.0f;
			shoulderTT = (shoulderTT - 4) % 45;
			shoulderTP = (shoulderTP - 4) % 60;
			elbowTT = (elbowTT + 4) % 90;
			elbowTP = (elbowTP + 4) % 90;

			x2 = x2 + 0.05f;
			y2 = y2 + 0.05f;
			z2 = z2 + 0.05f;
			myUT.glutPostRedisplay();
			break;

		case 'p': // Di ve phia truoc

			x11 = 1.0f;
			shoulderCT = (shoulderCT - 4) % 45;
			shoulderCP = (shoulderCP - 4) % 60;
			elbowCT = (elbowCT + 4) % 90;
			elbowCP = (elbowCP + 4) % 90;

			x1 = 1.0f;
			shoulderTT = (shoulderTT - 4) % 45;
			shoulderTP = (shoulderTP - 4) % 60;
			elbowTT = (elbowTT + 4) % 90;
			elbowTP = (elbowTP + 4) % 90;

			tx = tx + 0.1f;
			myUT.glutPostRedisplay();
			break;
		case 'P': // Di ve phia truoc

			x11 = 1.0f;
			shoulderCT = (shoulderCT - 4) % 45;
			shoulderCP = (shoulderCP - 4) % 60;
			elbowCT = (elbowCT + 4) % 90;
			elbowCP = (elbowCP + 4) % 90;

			x1 = 1.0f;
			shoulderTT = (shoulderTT - 4) % 45;
			shoulderTP = (shoulderTP - 4) % 60;
			elbowTT = (elbowTT + 4) % 90;
			elbowTP = (elbowTP + 4) % 90;

			tx = tx - 0.1f;
			myUT.glutPostRedisplay();
			break;
		case 'f': // Di ve phia truoc

			x11 = 1.0f;
			shoulderCT = (shoulderCT - 4) % 45;
			shoulderCP = (shoulderCP - 4) % 60;
			elbowCT = (elbowCT + 4) % 90;
			elbowCP = (elbowCP + 4) % 90;

			x1 = 1.0f;
			shoulderTT = (shoulderTT - 4) % 45;
			shoulderTP = (shoulderTP - 4) % 60;
			elbowTT = (elbowTT + 4) % 90;
			elbowTP = (elbowTP + 4) % 90;

			ty = ty + 0.1f;
			yTuyet = yTuyet + 0.1f ;
			myUT.glutPostRedisplay();
			break;
		case 'F': // Di ve phia truoc

			x11 = 1.0f;
			shoulderCT = (shoulderCT - 4) % 45;
			shoulderCP = (shoulderCP - 4) % 60;
			elbowCT = (elbowCT + 4) % 90;
			elbowCP = (elbowCP + 4) % 90;

			x1 = 1.0f;
			shoulderTT = (shoulderTT - 4) % 45;
			shoulderTP = (shoulderTP - 4) % 60;
			elbowTT = (elbowTT + 4) % 90;
			elbowTP = (elbowTP + 4) % 90;

			ty = ty - 0.1f;
			yTuyet = yTuyet - 0.1f ;
			myUT.glutPostRedisplay();
			break;
		case 27:
			System.exit(0);
		default:
			break;
		}
	}

	public void init() throws IOException {
		myUT.glutInitWindowSize(700, 600);
		myUT.glutInitWindowPosition(0, 0);
		myUT.glutCreateWindow(this);
		myinit();
		myUT.glutDisplayFunc("display");
		myUT.glutReshapeFunc("myReshape");
//		myUT.glutMouseFunc("mouse");
		myUT.glutKeyboardFunc("keyboard");
		myUT.glutMainLoop();
	}

	static public void main(String args[]) throws IOException {
		Frame mainFrame = new Frame();
		mainFrame.setSize(700, 600);
		RoBot mainCanvas = new RoBot();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
