import com.sun.deploy.panel.ControlPanel;
import javafx.scene.layout.Border;
import theme.SButton;
import theme.SPanel;
import theme.Theme;
import token.Token;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MainFrame extends JFrame
{
    public static MainFrame instance = null;
    private SPanel contentPane;

    private SPanel controlPanel;
    private SPanel outputPanel;

    private OutputTextArea outputTextArea;
    private String sourceCode = "";

    private LexicalEngine lexicalEngine;

    public MainFrame getInstance()
    {
        if(instance == null)
            instance = new MainFrame();
        return instance;
    }

    private MainFrame()
    {
        lexicalEngine = new LexicalEngine();

        initWindow();

        controlPanel = initControlPanel();
        outputTextArea = new OutputTextArea();
        outputPanel = initOutputPanel(outputTextArea);

        contentPane.setLayout(new BorderLayout(5,5));
        contentPane.add(controlPanel, BorderLayout.WEST);
        contentPane.add(outputPanel, BorderLayout.CENTER);
    }

    private void initWindow()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mon analyseur lexical, syntaxique et sémantique");
        setBounds(100, 100, Theme.WINDOW_WIDTH, Theme.WINDOW_HEIGHT);

        contentPane = new SPanel();
        contentPane.setLayout(new BorderLayout(5,5));
        setContentPane(contentPane);
    }

    private SPanel initOutputPanel(OutputTextArea outputTextArea)
    {
        SPanel outputPanel = new SPanel();
        outputPanel.setLayout(new BorderLayout(5,5));

        JLabel outLabel = new JLabel("Sortie : ");
        outLabel.setFont(Theme.FONT_DEFAULT);
        outLabel.setForeground(Theme.FONT_DEFAULT_COLOR);
        outputPanel.add(outLabel, BorderLayout.NORTH);

        outputPanel.add(this.outputTextArea, BorderLayout.CENTER);

        return outputPanel;
    }

    private SPanel initControlPanel()
    {
        SPanel controlPanel = new SPanel();
        controlPanel.setLayout(new BorderLayout(5,5));

        JLabel cmdLabel = new JLabel("Commandes : ");
        cmdLabel.setFont(Theme.FONT_DEFAULT);
        cmdLabel.setForeground(Theme.FONT_DEFAULT_COLOR);

        controlPanel.add(cmdLabel, BorderLayout.NORTH);

        SPanel buttonsPanel = new SPanel();

        SButton loadFileButton = new SButton("Charger un fichier");
        SButton lexicalButton = new SButton("Analyse Lexicale");
        SButton syntaxButton = new SButton("Analyse Syntaxique");
        SButton SymanticButton = new SButton("Analyse Sémantique");

        loadFileButton.setIcon(FileManager.loadImage("magnifying_glass"));
        lexicalButton.setIcon(FileManager.loadImage("Letters-icon"));
        syntaxButton.setIcon(FileManager.loadImage("layers-icon"));
        SymanticButton.setIcon(FileManager.loadImage("source-code"));


        loadFileButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadSourceCode();
            }
        });
        lexicalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lexicalEngine.setSourceCode(sourceCode);
                showLexicalResult(lexicalEngine.getTokenSource());
            }
        });
        syntaxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        SymanticButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonsPanel.setLayout(new GridLayout(4, 1, 10, 5));

        buttonsPanel.add(loadFileButton);
        buttonsPanel.add(lexicalButton);
        buttonsPanel.add(syntaxButton);
        buttonsPanel.add(SymanticButton);

        controlPanel.add(buttonsPanel, BorderLayout.CENTER);

        return controlPanel;
    }

    private void showLexicalResult(ArrayList<Token> tokenSource)
    {
        outputTextArea.setText("");
        for(Token t : tokenSource)
        {
            outputTextArea.appendtext(t.getText() + " : id\n");
        }
    }


    private void loadSourceCode()
    {
        String sourceCode = FileManager.getLoadedFileText();

        outputTextArea.setText(sourceCode);
        this.sourceCode = sourceCode;
    }

    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
