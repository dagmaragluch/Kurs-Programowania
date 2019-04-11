package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;

import static java.awt.geom.Point2D.distance;

public class DrawArea extends JPanel {

    private BufferedImage paintImage;
    private Graphics2D g2d;
    private int startX, startY, endX, endY;
    private double radius, diameter;    //zmienne do tworzenia koła
    private int counter = -1; //licznik kliknięć przy tworzeniu wielokąta
    private Point movingPoint;  //punkt, który przechowuje współrzędne kursora przy przesuwaniu

    private ArrayList<Rectangle2D> areas = new ArrayList<Rectangle2D>();    //przechowuje obrysy wielokątów
    private ArrayList<Rectangle2D> rectangles = new ArrayList<Rectangle2D>();   //przechowuje prostokąty
    private ArrayList<Ellipse2D> circles = new ArrayList<Ellipse2D>();  //przechowuje koła
    private ArrayList<Color> circlesColors = new ArrayList<Color>();    //przechowuje kolory poszczególnych kół
    private ArrayList<Color> rectanglesColors = new ArrayList<Color>(); //przechowuje kolory poszczególnych prostokątów
    private ArrayList<Shape> polygons = new ArrayList<Shape>();     //przechowuje wielokąty

    private int[] wspX = new int[20];       //tablice wapółrzędnych
    private int[] wspY = new int[20];       //do tworzenia wielokąta


    public DrawArea() {

        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {

                endX = e.getX();    //pobranie współrzędnych puszczenia
                endY = e.getY();

                switch (Toolbar.selectedTool) {
                    case 1:     //tworzenie PROSTOKĄTa
                        counter = -1;
                        Rectangle2D prostokat = new Rectangle2D.Double();
                        prostokat.setFrameFromDiagonal(startX, startY, endX, endY);   //tworzenie prostokątu z przekątnej
                        g2d.setColor(Color.RED);
                        rectanglesColors.add(Color.RED);
                        g2d.fill(prostokat);

                        rectangles.add(prostokat);
                        updatePaint();
                        break;

                    case 2:     //tworzenie KOLA
                        counter = -1;
                        radius = distance(startX, startY, endX, endY);
                        diameter = radius * 2;

                        Ellipse2D circle = new Ellipse2D.Double(startX - radius, startY - radius, diameter, diameter);
                        g2d.setColor(Color.BLUE);
                        circlesColors.add(Color.BLUE);
                        g2d.fill(circle);

                        circles.add(circle);

                        break;

                    case 3:     //PRZESUWANIE FIGUR
                        counter = -1;
                        for (int i = 0; i < circles.size(); i++) {
                            if (circles.get(i).contains(startX, startY)) {
                                circles.get(i).setFrame(endX - ((circles.get(i).getWidth()) / 2), endY - ((circles.get(i).getWidth()) / 2), circles.get(i).getWidth(), circles.get(i).getHeight());
                                break;
                            }
                        }
                        for (int i = 0; i < rectangles.size(); i++) {
                            if (rectangles.get(i).contains(startX, startY)) {
                                rectangles.get(i).setFrame(endX, endY, rectangles.get(i).getWidth(), rectangles.get(i).getHeight());
                                break;
                            }
                        }
                        for (int i = 0; i < polygons.size(); i++) {
                            if (polygons.get(i).contains(startX, startY)) {
                                AffineTransform tx = new AffineTransform();
                                tx.translate(endX - startX, endY - startY);
                                Shape shape = tx.createTransformedShape(polygons.get(i));
                                polygons.set(i, shape);
                                break;
                            }
                        }
                        refreshScreen();
                        break;

                    default:
                        break;
                }
                repaint();
            }


            @Override
            public void mousePressed(MouseEvent e) {

                startX = e.getX();  //pobieranie współrzędnych kliknięcia
                startY = e.getY();

                switch (Toolbar.selectedTool) {
                    case 4:             //malowanie na zielono
                        drawColor(Color.GREEN);
                        break;

                    case 11:        //malowanie na czerwono
                        drawColor(Color.RED);
                        break;

                    case 5:         //malowanie na niebiesko
                        drawColor(Color.BLUE);
                        break;

                    case 6:             //WIEKSZY
                        counter = -1;
                        for (int i = 0; i < circles.size(); i++) {
                            if (circles.get(i).contains(startX, startY)) {
                                if ((circles.get(i).getWidth()) <= 400) {
                                    circles.get(i).setFrame(circles.get(i).getX(), circles.get(i).getY(), (circles.get(i).getWidth()) * 1.2, (circles.get(i).getHeight()) * 1.2);
                                }
                                break;
                            }
                        }
                        for (int i = 0; i < rectangles.size(); i++) {
                            if (rectangles.get(i).contains(startX, startY)) {
                                if ((rectangles.get(i).getWidth()) <= 350 && (rectangles.get(i).getHeight()) <= 350) {
                                    rectangles.get(i).setFrame(rectangles.get(i).getX(), rectangles.get(i).getY(), (rectangles.get(i).getWidth()) * 1.2, (rectangles.get(i).getHeight()) * 1.2);
                                }
                                break;
                            }
                        }
                        for (int i = 0; i < polygons.size(); i++) {
                            if (polygons.get(i).contains(startX, startY)) {

                                AffineTransform ts = new AffineTransform();
                                ts.scale(1.2, 1.2);
                                //ts.translate(endX - startX, endY - startY);

                                Shape shape = ts.createTransformedShape(polygons.get(i));
                                polygons.set(i, shape);
                                break;
                            }
                        }
                        refreshScreen();
                        break;


                    case 7:         //MNIEJSZY
                        counter = -1;
                        for (int i = 0; i < circles.size(); i++) {
                            if (circles.get(i).contains(startX, startY)) {
                                if ((circles.get(i).getWidth()) >= 10) {
                                    circles.get(i).setFrame(circles.get(i).getX(), circles.get(i).getY(), (circles.get(i).getWidth()) * 0.8, (circles.get(i).getHeight()) * 0.8);
                                }
                                break;
                            }
                        }
                        for (int i = 0; i < rectangles.size(); i++) {
                            if (rectangles.get(i).contains(startX, startY)) {
                                if ((rectangles.get(i).getWidth()) >= 10 && (rectangles.get(i).getHeight()) >= 10) {
                                    rectangles.get(i).setFrame(rectangles.get(i).getX(), rectangles.get(i).getY(), (rectangles.get(i).getWidth()) * 0.8, (rectangles.get(i).getHeight()) * 0.8);
                                }
                                break;
                            }
                        }
                        for (int i = 0; i < polygons.size(); i++) {
                            if (polygons.get(i).contains(startX, startY)) {
                                AffineTransform ts = new AffineTransform();
                                ts.scale(0.8, 0.8);
                                //ts.translate(0, -1*deltaH);
                                Shape shape = ts.createTransformedShape(polygons.get(i));
                                polygons.set(i, shape);

                                break;
                            }
                        }
                        refreshScreen();
                        break;

                    case 8:     //tworzenie WIELOKĄTA
                        counter++;
                        wspX[counter] = e.getX();    //zapis pobranych wsółrzędnych do tablic
                        wspY[counter] = e.getY();

                        if (e.getClickCount() == 2 || counter == 19) {     //wielokąt tworzy się po podwójnym kliknięciu lub gdy kliknięto już 20 razy
                            Polygon poly = new Polygon(wspX, wspY, counter);
                            g2d.setColor(Color.BLACK);
                            g2d.fill(poly);
                            polygons.add(poly);
                            areas.add(poly.getBounds2D());
                            counter = -1;     //"zerujemy" licznik
                        }
                        break;

                    case 9:     //SAVE
                        try {
                            save();
                        } catch (IOException ex1) {
                            System.out.println("Błąd zapisu");
                        }
                        break;

                    case 10:        //LOAD
                        BufferedImage paintImage = null;
                        try {
                            load();
                        } catch (IOException ex2) {
                            System.out.println("Błąd odczytu");
                        }
                        break;

                    default:
                        break;
                }
            }

        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                if (Toolbar.selectedTool == 3) {  //rzeczy potrzebene do wyświetlania informacji o przesuwanej figurze
                    for (int i = 0; i < circles.size(); i++) {
                        if (circles.get(i).contains(startX, startY)) {
                            movingPoint = e.getPoint();

                            Rectangle2D kratka = new Rectangle2D.Double(0, 490, 100, 40);
                            g2d.setColor(Color.YELLOW);
                            g2d.fill(kratka);

                            Font system = new Font("System", Font.PLAIN, 12);
                            g2d.setFont(system);
                            g2d.setColor(Color.BLACK);
                            g2d.drawString("x: " + movingPoint.x, 5, 505);
                            g2d.drawString(" y: " + movingPoint.y, 50, 505);
                            g2d.drawString("w: " + (int) circles.get(i).getWidth(), 5, 520);
                            g2d.drawString(" h: " + (int) circles.get(i).getHeight(), 50, 520);
                            repaint();
                        }
                    }
                    for (int i = 0; i < rectangles.size(); i++) {
                        if (rectangles.get(i).contains(startX, startY)) {

                            movingPoint = e.getPoint();

                            Rectangle2D kratka = new Rectangle2D.Double(0, 490, 100, 40);
                            g2d.setColor(Color.YELLOW);
                            g2d.fill(kratka);

                            Font system = new Font("System", Font.PLAIN, 12);
                            g2d.setFont(system);
                            g2d.setColor(Color.BLACK);
                            g2d.drawString("x: " + movingPoint.x, 5, 505);
                            g2d.drawString(" y: " + movingPoint.y, 50, 505);
                            g2d.drawString("w: " + (int) rectangles.get(i).getWidth(), 5, 520);
                            g2d.drawString(" h: " + (int) rectangles.get(i).getHeight(), 50, 520);
                            repaint();
                        }
                    }
                    for (int i = 0; i < polygons.size(); i++) {
                        if (polygons.get(i).contains(startX, startY)) {

                            movingPoint = e.getPoint();

                            Rectangle2D kratka = new Rectangle2D.Double(0, 490, 100, 40);
                            g2d.setColor(Color.YELLOW);
                            g2d.fill(kratka);

                            Font system = new Font("System", Font.PLAIN, 12);
                            g2d.setFont(system);
                            g2d.setColor(Color.BLACK);
                            g2d.drawString("x: " + movingPoint.x, 5, 505);
                            g2d.drawString(" y: " + movingPoint.y, 50, 505);
                            g2d.drawString("w: " + (int) areas.get(i).getWidth(), 5, 520);
                            g2d.drawString(" h: " + (int) areas.get(i).getHeight(), 50, 520);

                            repaint();
                        }
                    }
                }
            }
        });


    }

    protected void paintComponent(Graphics g) {

        if (paintImage == null) {

            paintImage = new BufferedImage(600, 520, BufferedImage.TYPE_INT_RGB);
            g2d = (Graphics2D) paintImage.getGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            clear();  //metoda którą tworzymy niżej
        }
        g.drawImage(paintImage, 0, 0, null);
    }


    public void updatePaint() {
        Graphics2D g2d = paintImage.createGraphics();
        g2d.dispose();
        repaint();
    }

    public void save() throws IOException {  //metoda zapisu do pliku
        ImageIO.write(paintImage, "PNG", new File("filename1.png"));
    }

    public void load() throws IOException { //metoda odczytu z pliku
        paintImage = ImageIO.read(new File("filename1.png"));
        repaint();
    }

    private void clear() {    //maluje cały panel na biało
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getSize().width, getSize().height);
        repaint();
    }

    private void refreshScreen() {   //przerysowuje wszystkie figury
        clear();
        for (int j = 0; j < circles.size(); j++) {
            g2d.setColor(circlesColors.get(j));
            g2d.fill(circles.get(j));
        }
        for (int j = 0; j < rectangles.size(); j++) {
            g2d.setColor(rectanglesColors.get(j));
            g2d.fill(rectangles.get(j));
        }
        for (int j = 0; j < polygons.size(); j++) {
            g2d.setColor(Color.BLACK);
            g2d.fill(polygons.get(j));
        }
        updatePaint();
    }


    private void drawColor(Color color) {
        counter = -1;
        for (int i = 0; i < circles.size(); i++) {
            if (circles.get(i).contains(startX, startY)) {
                g2d.setColor(color);
                circlesColors.set(i, color);
                g2d.fill(circles.get(i));
                break;
            }
        }
        for (int i = 0; i < rectangles.size(); i++) {
            if (rectangles.get(i).contains(startX, startY)) {
                g2d.setColor(color);
                rectanglesColors.set(i, color);
                g2d.fill(rectangles.get(i));
                break;
            }
        }
    }


}

