import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class SpisFakturTest {
    private SpisFaktur spisFaktur = new SpisFaktur();
    private int ilosc_elementow = 2;
    private ArrayList<Faktura> listaFaktur = new ArrayList<Faktura>();
    private ArrayList<Element> listaElem = new ArrayList<Element>();
    private Klient klient = new Klient("Alojzy");
    private Faktura faktura;

    @Before
    public void init() {
        faktura = new Faktura(klient, listaElem);
    }

    @Test
    public void powinienDodacFakture() {
        listaFaktur.add(faktura);
        Assert.assertEquals("Powinno dodoac fakture (1)", listaFaktur.size(), 1);
    }

    @Test
    public void powinienDodacDwaElementyDoFaktury() {
        for (int i = 0; i < ilosc_elementow; i++) {
            faktura.dadaj_element("krzesło", 4, 100);
        }
        Assert.assertEquals("Faktura powinna miec 2 elementy", faktura.getElementy().size(), 2);
        Assert.assertEquals("Nazwa artykulu powinna byc \"krzesło\"", faktura.getElementy().get(0).getArtykul(), "krzesło");
        Assert.assertEquals("Ilość powinna byc 4", faktura.getElementy().get(0).getIlosc(), 4);
        Assert.assertEquals("Cena powinna byc 100.0", faktura.getElementy().get(0).getCena(), 100.0, 0.001);
    }

}
