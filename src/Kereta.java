public class Kereta {
    private String namaKereta;
    private int sisaTicket;    
    
    // object member
    private Ticket ticket;

    public Kereta(){
        this.namaKereta = "Komuter";
        this.sisaTicket = 1000;
        this.ticket = new Ticket();
    }

    public Kereta(String namaKereta, int sisaTicket){
        this.namaKereta = namaKereta;
        this.sisaTicket = sisaTicket;
        this.ticket = new Ticket(namaKereta, sisaTicket);
    }

    public void tambahTiket(String namaPenumpang){
       String[] nama = new String[ticket.getNamaPenumpang().length + 1];
       System.arraycopy(ticket.getNamaPenumpang(), 0, nama, 0, ticket.getNamaPenumpang().length);
       nama[ticket.getNamaPenumpang().length] = namaPenumpang;
       ticket.setNamaPenumpang(nama);

       System.out.println("==================================================");
       System.out.println("Tiket berhasil dipesan");     
    }

    public void tambahTiket(String namaPenumpang, String a, String t){
        if(ticket.getNamaPenumpang().length < sisaTicket){
            String[] nama = new String[ticket.getNamaPenumpang().length + 1];
            String[] asal = new String[ticket.getAsal().length + 1];
            String[] tujuan = new String[ticket.getTujuan().length + 1];

            System.arraycopy(ticket.getNamaPenumpang(), 0, nama, 0, ticket.getNamaPenumpang().length);
            System.arraycopy(ticket.getAsal(), 0, asal, 0, ticket.getAsal().length);
            System.arraycopy(ticket.getTujuan(), 0, tujuan, 0, ticket.getTujuan().length);

            nama[ticket.getNamaPenumpang().length] = namaPenumpang;
            asal[ticket.getAsal().length] = a;
            tujuan[ticket.getTujuan().length] = t;

            ticket.setNamaPenumpang(nama);
            ticket.setAsal(asal);
            ticket.setTujuan(tujuan);

            if(sisaTicket - ticket.getNamaPenumpang().length < 30){
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + (sisaTicket - ticket.getNamaPenumpang().length));
            } else {
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan");
            }       

        } else {
            System.out.println("==================================================");
            System.out.println("kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya"); 
        }       
    }

    public void tampilkanTiket(){
        System.out.println("==================================================");
        System.out.println("Daftar penumpang kereta api " + this.namaKereta + ": ");
        System.out.println("----------------------------");

        for(int i = 0; i < ticket.getNamaPenumpang().length; i++){
            if(this.namaKereta.equals("Komuter")){
                System.out.println("Nama: " + this.ticket.getNamaPenumpang()[i]);
            } else {
                System.out.println("Nama: " + this.ticket.getNamaPenumpang()[i]);
                System.out.println("Asal: " + this.ticket.getAsal()[i]);
                System.out.println("Tujuan: " + this.ticket.getTujuan()[i]);
                System.out.println("-----------------------------");
            }
        }
    }
    
}
 
