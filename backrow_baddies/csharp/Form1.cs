using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            OpenFileDialog fDialog = new OpenFileDialog();

            fDialog.Title = "Open Image Files";

            fDialog.Filter = "Java files|*.java";

            fDialog.InitialDirectory = @"C:\";

            if (fDialog.ShowDialog() == DialogResult.OK)
            {
                var s = File.ReadAllLines(fDialog.FileName.ToString());

                int ras_mult = 1;
                int ras_count = 0;

                for (int i = 0; i < s.Length; i++)
                {
                    for (int j = 0; j < s[i].Length; j++)
                    {
                        switch (s[i][j])
                        {
                            case '{':
                                ras_mult++;
                                break;
                            case '}':
                                ras_mult--;
                                break;
                            case ';':
                                ras_count += ras_mult;
                                break;
                            default:
                                break;
                        }
                    }
                }

                label1.Text = "Result: " + ras_count;
                //MessageBox.Show(ras_count+"");
            }

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            label1.Text = "Result: ";
        }
    }
}
