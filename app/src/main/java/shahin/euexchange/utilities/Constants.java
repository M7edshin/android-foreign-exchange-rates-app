package shahin.euexchange.utilities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.List;

import shahin.euexchange.BuildConfig;
import shahin.euexchange.R;
import shahin.euexchange.models.Rate;

public class Constants {

    //Fixer Client API
    public static final String BASE_URL = "http://data.fixer.io/api/latest";
    public static final String API_ACCESS_KEY = BuildConfig.API_ACCESS_KEY;
    public static final String PAR_ACCESS_KEY = "access_key";

    //MainActivity
    public static final int LOADER_ID = 1;

    public static void accessPrivacyPolicy(Context context) {
        String url = "https://github.com/M7edshin/Privacy-Policy";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }

    public static void setAdditionalCountryContent(List<Rate> rateList) {
        rateList.get(0).setImageId(R.drawable.aed_united_arab_emirates);
        rateList.get(0).setCountry("United Arab Emirates");
        rateList.get(0).setCurrency("Emirati Dirham");

        rateList.get(1).setImageId(R.drawable.afn_afghanistan);
        rateList.get(1).setCountry("Afghanistan");
        rateList.get(1).setCurrency("Afghan Afghani");

        rateList.get(2).setImageId(R.drawable.all_albania);
        rateList.get(2).setCountry("Albania");
        rateList.get(2).setCurrency("Albanian Lek");

        rateList.get(3).setImageId(R.drawable.amd_armenia);
        rateList.get(3).setCountry("Armenia");
        rateList.get(3).setCurrency("Armenian Dram");

        rateList.get(4).setImageId(R.drawable.ang_netherlands);
        rateList.get(4).setCountry("Netherlands");
        rateList.get(4).setCurrency("Dutch Guilder");

        rateList.get(5).setImageId(R.drawable.aoa_angola);
        rateList.get(5).setCountry("Angola");
        rateList.get(5).setCurrency("Angolan Kwanza");

        rateList.get(6).setImageId(R.drawable.ars_argentina);
        rateList.get(6).setCountry("Argentina");
        rateList.get(6).setCurrency("Argentine Peso");

        rateList.get(7).setImageId(R.drawable.aud_australia);
        rateList.get(7).setCountry("Australia, Kiribati, Coconut Islands, Nauru, Tuvalu");
        rateList.get(7).setCurrency("Australian Dollar");

        rateList.get(8).setImageId(R.drawable.awg_aruba);
        rateList.get(8).setCountry("Aruba");
        rateList.get(8).setCurrency("Aruban florin");

        rateList.get(9).setImageId(R.drawable.azn_azerbaijan);
        rateList.get(9).setCountry("Azerbaijan");
        rateList.get(9).setCurrency("Azerbaijani manat");

        rateList.get(10).setImageId(R.drawable.bam_bosnia_and_herzegovina);
        rateList.get(10).setCountry("Bosnia and Herzegovina");
        rateList.get(10).setCurrency("Bosnian Convertible Marka");

        rateList.get(11).setImageId(R.drawable.bbd_barbados);
        rateList.get(11).setCountry("Barbados");
        rateList.get(11).setCurrency("Barbadian or Bajan Dollar");

        rateList.get(12).setImageId(R.drawable.bdt_bangladesh);
        rateList.get(12).setCountry("Bbangladesh");
        rateList.get(12).setCurrency("Bangladeshi taka");

        rateList.get(13).setImageId(R.drawable.bgn_bulgaria);
        rateList.get(13).setCountry("Bulgaria");
        rateList.get(13).setCurrency("Bulgarian lev");

        rateList.get(14).setImageId(R.drawable.bhd_bahrain);
        rateList.get(14).setCountry("Bahrain");
        rateList.get(14).setCurrency("Bahraini dinar");

        rateList.get(15).setImageId(R.drawable.bif_burundi);
        rateList.get(15).setCountry("Burundi");
        rateList.get(15).setCurrency("Burundian franc");

        rateList.get(16).setImageId(R.drawable.bmd_bermuda);
        rateList.get(16).setCountry("Bermuda");
        rateList.get(16).setCurrency("Bermudian dollar");

        rateList.get(17).setImageId(R.drawable.bnd_brunei);
        rateList.get(17).setCountry("Brunei, Singapore");
        rateList.get(17).setCurrency("Brunei dollar");

        rateList.get(18).setImageId(R.drawable.bob_bolivia);
        rateList.get(18).setCountry("Bolivia");
        rateList.get(18).setCurrency("Bolivian Bolíviano");

        rateList.get(19).setImageId(R.drawable.brl_brazil);
        rateList.get(19).setCountry("Brazil");
        rateList.get(19).setCurrency("Brazilian real");

        rateList.get(20).setImageId(R.drawable.bsd_bahamas);
        rateList.get(20).setCountry("Bahamas");
        rateList.get(20).setCurrency("Bahamian Dollar");

        rateList.get(21).setImageId(R.drawable.bitcoin);
        rateList.get(21).setCountry("Virtual Currency (WorldWide)");
        rateList.get(21).setCurrency("Bitcoin");

        rateList.get(22).setImageId(R.drawable.btn_bhutan);
        rateList.get(22).setCountry("Bhutan");
        rateList.get(22).setCurrency("Bhutanese Ngultrum");

        rateList.get(23).setImageId(R.drawable.bwp_botswana);
        rateList.get(23).setCountry("Botswana");
        rateList.get(23).setCurrency("Botswana pula");

        rateList.get(24).setImageId(R.drawable.byn_belarus);
        rateList.get(24).setCountry("Belarus");
        rateList.get(24).setCurrency("Belarusian ruble");

        rateList.get(25).setImageId(R.drawable.byn_belarus);
        rateList.get(25).setCountry("Belarus");
        rateList.get(25).setCurrency("Belarusian ruble");

        rateList.get(26).setImageId(R.drawable.bzd_belize);
        rateList.get(26).setCountry("Belize");
        rateList.get(26).setCurrency("Belize dollar");

        rateList.get(27).setImageId(R.drawable.cad_canada);
        rateList.get(27).setCountry("Canada");
        rateList.get(27).setCurrency("Canadian Dollar");

        rateList.get(28).setImageId(R.drawable.cdf_democratic_republic_of_congo);
        rateList.get(28).setCountry("Democratic Republic of Congo");
        rateList.get(28).setCurrency("Congolese Franc");

        rateList.get(29).setImageId(R.drawable.chf_switzerland);
        rateList.get(29).setCountry("Switzerland, Lichtenstein");
        rateList.get(29).setCurrency("Swiss Franc");

        rateList.get(30).setImageId(R.drawable.clf_chile);
        rateList.get(30).setCountry("Chile");
        rateList.get(30).setCurrency("Chilean Unidad de Fomento");

        rateList.get(31).setImageId(R.drawable.clf_chile);
        rateList.get(31).setCountry("Chile");
        rateList.get(31).setCurrency("Chilean Peso");

        rateList.get(32).setImageId(R.drawable.cny_china);
        rateList.get(32).setCountry("China");
        rateList.get(32).setCurrency("Chinese Yuan");

        rateList.get(33).setImageId(R.drawable.cop_colombia);
        rateList.get(33).setCountry("Colombia");
        rateList.get(33).setCurrency("Colombian Peso");

        rateList.get(34).setImageId(R.drawable.crc_costa_rica);
        rateList.get(34).setCountry("Costa Rica");
        rateList.get(34).setCurrency("Costa Rican Colon");

        rateList.get(35).setImageId(R.drawable.cuc_cuba);
        rateList.get(35).setCountry("Cuba");
        rateList.get(35).setCurrency("Cuban Convertible Peso");

        rateList.get(36).setImageId(R.drawable.cuc_cuba);
        rateList.get(36).setCountry("Cuba");
        rateList.get(36).setCurrency("Cuban Peso");

        rateList.get(37).setImageId(R.drawable.cve_cape_verde);
        rateList.get(37).setCountry("Cape Verde");
        rateList.get(37).setCurrency("Cape Verdean Escudo");

        rateList.get(38).setImageId(R.drawable.czk_czech_republic);
        rateList.get(38).setCountry("Czechia");
        rateList.get(38).setCurrency("Czech koruna");

        rateList.get(39).setImageId(R.drawable.djf_djibouti);
        rateList.get(39).setCountry("Djibouti");
        rateList.get(39).setCurrency("Djiboutian Franc");

        rateList.get(40).setImageId(R.drawable.dkk_denmark);
        rateList.get(40).setCountry("Denmark");
        rateList.get(40).setCurrency("Danish Krone");

        rateList.get(41).setImageId(R.drawable.dop_dominican_republic);
        rateList.get(41).setCountry("Dominican Republic");
        rateList.get(41).setCurrency("Dominican Peso");

        rateList.get(42).setImageId(R.drawable.dzd_algeria);
        rateList.get(42).setCountry("Algeria");
        rateList.get(42).setCurrency("Algerian Dinar");

        rateList.get(43).setImageId(R.drawable.egp_egypt);
        rateList.get(43).setCountry("Egypt");
        rateList.get(43).setCurrency("Egyptian pound");

        rateList.get(44).setImageId(R.drawable.ern_eritrea);
        rateList.get(44).setCountry("Eritrea");
        rateList.get(44).setCurrency("Eritrean Nakfa");

        rateList.get(45).setImageId(R.drawable.etb_ethiopia);
        rateList.get(45).setCountry("Ethiopia");
        rateList.get(45).setCurrency("Ethiopian Birr");

        rateList.get(21).setImageId(R.mipmap.ic_launcher);
        rateList.get(46).setCountry("Akrotiri and Dhekelia, Andorra, Austria, Belgium, Cyprus, " +
                "Estonia, Finland, France, Germany, Greece, Ireland, Italy, Kosovo, Latvia, Lithuania" +
                "Luxembourg, Malta, Monaco, Montenegro, Netherlands, Portugal, San-Marino, Slovakia" +
                "Slovenia, Spain, Vatican");
        rateList.get(46).setCurrency("Euro");

        rateList.get(47).setImageId(R.drawable.fjd_fiji);
        rateList.get(47).setCountry("Fiji");
        rateList.get(47).setCurrency("Fijian dollar");

        rateList.get(48).setImageId(R.drawable.fkp_falkland_islands);
        rateList.get(48).setCountry("Falkland Island");
        rateList.get(48).setCurrency("Falkland Island Pound");


        rateList.get(49).setImageId(R.drawable.gbp_england);
        rateList.get(49).setCountry("England");
        rateList.get(49).setCurrency("Sterling");

        rateList.get(50).setImageId(R.drawable.gel_georgia);
        rateList.get(50).setCountry("Georgia");
        rateList.get(50).setCurrency("Georgian Lari");

        rateList.get(51).setImageId(R.drawable.ggp_guernsey);
        rateList.get(51).setCountry("Guernsey");
        rateList.get(51).setCurrency("Guernsey Pound");

        rateList.get(52).setImageId(R.drawable.ghs_ghana);
        rateList.get(52).setCountry("Ghana");
        rateList.get(52).setCurrency("Ghanaian Cedi");

        rateList.get(53).setImageId(R.drawable.gip_gibraltar);
        rateList.get(53).setCountry("Gibraltar");
        rateList.get(53).setCurrency("Gibraltar pound");

        rateList.get(54).setImageId(R.drawable.gmd_gambia);
        rateList.get(54).setCountry("Gambia");
        rateList.get(54).setCurrency("Gambian Dalasi");

        rateList.get(55).setImageId(R.drawable.gnf_guinea);
        rateList.get(55).setCountry("Guinea");
        rateList.get(55).setCurrency("Guinean franc");

        rateList.get(56).setImageId(R.drawable.gtq_guatemala);
        rateList.get(56).setCountry("Guatemala");
        rateList.get(56).setCurrency("Guatemalan Quetzal");

        rateList.get(57).setImageId(R.mipmap.ic_launcher);
        rateList.get(57).setCountry("British Guiana");
        rateList.get(57).setCurrency("Guyanaese Dollar");

        rateList.get(58).setImageId(R.drawable.hkd_hong_kong);
        rateList.get(58).setCountry("Hong Kong");
        rateList.get(58).setCurrency("Hong Kong Dollar");

        rateList.get(59).setImageId(R.drawable.hnl_honduras);
        rateList.get(59).setCountry("Honduras");
        rateList.get(59).setCurrency("Honduran Lempira");

        rateList.get(60).setImageId(R.drawable.hrk_croatia);
        rateList.get(60).setCountry("Croatia");
        rateList.get(60).setCurrency("Croatian Kuna");

        rateList.get(61).setImageId(R.drawable.htg_haiti);
        rateList.get(61).setCountry("Haiti");
        rateList.get(61).setCurrency("Haitian Gourde");

        rateList.get(62).setImageId(R.drawable.huf_hungary);
        rateList.get(62).setCountry("Hungary");
        rateList.get(62).setCurrency("Hungarian Forint");

        rateList.get(63).setImageId(R.drawable.idr_indonesia);
        rateList.get(63).setCountry("Indonesia");
        rateList.get(63).setCurrency("Indonesian Rupiah");

        //rateList.get(64).setImageId(R.drawable.); "Israel"
        rateList.get(64).setCountry("N/A");
        rateList.get(64).setCurrency("N/A");

        rateList.get(65).setImageId(R.drawable.imp_isle_of_man);
        rateList.get(65).setCountry("Isle of man");
        rateList.get(65).setCurrency("Isle of Man Pound");

        rateList.get(66).setImageId(R.drawable.inr_india);
        rateList.get(66).setCountry("India");
        rateList.get(66).setCurrency("Indian rupee");

        rateList.get(67).setImageId(R.drawable.iqd_iraq);
        rateList.get(67).setCountry("Iraq");
        rateList.get(67).setCurrency("Iraqi Dinar");

        rateList.get(68).setImageId(R.drawable.irr_iran);
        rateList.get(68).setCountry("Iran");
        rateList.get(68).setCurrency("Iranian Rial");

        rateList.get(69).setImageId(R.drawable.isk_iceland);
        rateList.get(69).setCountry("Iceland");
        rateList.get(69).setCurrency("Icelandic Krona");

        rateList.get(70).setImageId(R.drawable.jep_jersey);
        rateList.get(70).setCountry("Jersey");
        rateList.get(70).setCurrency("Jersey Pound");

        rateList.get(71).setImageId(R.drawable.jmd_jamaica);
        rateList.get(71).setCountry("Jamaica");
        rateList.get(71).setCurrency("Jamaican Dollar");

        rateList.get(72).setImageId(R.drawable.jod_jordan);
        rateList.get(72).setCountry("Jordan");
        rateList.get(72).setCurrency("Jordanian Dinar");

        rateList.get(73).setImageId(R.drawable.jpy_japan);
        rateList.get(73).setCountry("Japan");
        rateList.get(73).setCurrency("Japanese Yen");

        rateList.get(74).setImageId(R.drawable.kes_kenya);
        rateList.get(74).setCountry("Kenya");
        rateList.get(74).setCurrency("Kenyan Shilling");

        rateList.get(75).setImageId(R.drawable.kgs_kyrgyzstan);
        rateList.get(75).setCountry("Kyrgyzstan");
        rateList.get(75).setCurrency("Kyrgyzstani Som");

        rateList.get(76).setImageId(R.drawable.khr_cambodia);
        rateList.get(76).setCountry("Cambodia");
        rateList.get(76).setCurrency("Cambodian Riel");

        rateList.get(77).setImageId(R.drawable.kmf_comoros);
        rateList.get(77).setCountry("Comoros");
        rateList.get(77).setCurrency("Comorian Franc");

        rateList.get(78).setImageId(R.drawable.kpw_northkorea);
        rateList.get(78).setCountry("North Korea");
        rateList.get(78).setCurrency("North Korean Won");

        rateList.get(79).setImageId(R.drawable.krw_southkorea);
        rateList.get(79).setCountry("South Korea");
        rateList.get(79).setCurrency("South Korean Won");

        rateList.get(80).setImageId(R.drawable.kwd_kwait);
        rateList.get(80).setCountry("Kuwait");
        rateList.get(80).setCurrency("Kuwaiti Dinar");

        rateList.get(81).setImageId(R.drawable.kyd_caymanislands);
        rateList.get(81).setCountry("Caymanislands");
        rateList.get(81).setCurrency("Caymanian Dollar");

        rateList.get(82).setImageId(R.drawable.kzt_kazakhstan);
        rateList.get(82).setCountry("Kazakhstan");
        rateList.get(82).setCurrency("Kazakhstani Tenge");

        rateList.get(83).setImageId(R.drawable.lak_laos);
        rateList.get(83).setCountry("Laos");
        rateList.get(83).setCurrency("Lao Kip");

        rateList.get(84).setImageId(R.drawable.lbp_lebanon);
        rateList.get(84).setCountry("Lebanon");
        rateList.get(84).setCurrency("Lebanese pound");

        rateList.get(85).setImageId(R.drawable.lkr_srilanka);
        rateList.get(85).setCountry("Sri lanka");
        rateList.get(85).setCurrency("Sri Lankan Rupee");

        rateList.get(86).setImageId(R.drawable.lrd_liberia);
        rateList.get(86).setCountry("Liberia");
        rateList.get(86).setCurrency("Liberian Dollar");

        rateList.get(87).setImageId(R.drawable.lsl_lesotho);
        rateList.get(87).setCountry("Lesotho");
        rateList.get(87).setCurrency("Lesotho Loti");

        rateList.get(88).setImageId(R.drawable.ltl_lithuania);
        rateList.get(88).setCountry("Lithuania");
        rateList.get(88).setCurrency("Lithuanian Litas");

        rateList.get(89).setImageId(R.drawable.lvl_latvia);
        rateList.get(89).setCountry("Latvia");
        rateList.get(89).setCurrency("Lithuanian Litas");

        rateList.get(90).setImageId(R.drawable.lyd_libya);
        rateList.get(90).setCountry("Libya");
        rateList.get(90).setCurrency("Libyan Dinar");

        rateList.get(91).setImageId(R.drawable.mad_morocco);
        rateList.get(91).setCountry("Morocco");
        rateList.get(91).setCurrency("Moroccan Dirham");

        rateList.get(92).setImageId(R.drawable.mdl_moldova);
        rateList.get(92).setCountry("Moldova");
        rateList.get(92).setCurrency("Moldovan Leu");

        rateList.get(93).setImageId(R.drawable.mga_madagascar);
        rateList.get(93).setCountry("Madagascar");
        rateList.get(93).setCurrency("Malagasy Ariary");

        rateList.get(94).setImageId(R.drawable.mkd_republic_of_macedonia);
        rateList.get(94).setCountry("Republic of Macedonia");
        rateList.get(94).setCurrency("Macedonian Denar");

        rateList.get(95).setImageId(R.drawable.mmk_myanmar);
        rateList.get(95).setCountry("Myanmar");
        rateList.get(95).setCurrency("Burmese Kyat");

        rateList.get(96).setImageId(R.drawable.mnt_mongolia);
        rateList.get(96).setCountry("Mongolia");
        rateList.get(96).setCurrency("Mongolian Tughrik");

        rateList.get(97).setImageId(R.drawable.mop_macau);
        rateList.get(97).setCountry("Macau");
        rateList.get(97).setCurrency("Macau Pataca");

        rateList.get(98).setImageId(R.drawable.mro_mauritania);
        rateList.get(98).setCountry("Mauritania");
        rateList.get(98).setCurrency("Mauritanian Ouguiya");

        rateList.get(99).setImageId(R.drawable.mur_mauritius);
        rateList.get(99).setCountry("Mauritius");
        rateList.get(99).setCurrency("Mauritian Rupee");

        rateList.get(100).setImageId(R.drawable.mvr_maldives);
        rateList.get(100).setCountry("Maldives");
        rateList.get(100).setCurrency("Maldivian Rufiyaa");

        rateList.get(101).setImageId(R.drawable.mwk_malawi);
        rateList.get(101).setCountry("Malawi");
        rateList.get(101).setCurrency("Malawian Kwacha");

        rateList.get(102).setImageId(R.drawable.mxn_mexico);
        rateList.get(102).setCountry("Mexico");
        rateList.get(102).setCurrency("Mexican peso");

        rateList.get(103).setImageId(R.drawable.myr_malasya);
        rateList.get(103).setCountry("Malasya");
        rateList.get(103).setCurrency("Malaysian Ringgit");

        rateList.get(104).setImageId(R.drawable.mzn_mozambique);
        rateList.get(104).setCountry("Mozambique");
        rateList.get(104).setCurrency("Mozambican metical");

        rateList.get(105).setImageId(R.drawable.nad_namibia);
        rateList.get(105).setCountry("Namibia");
        rateList.get(105).setCurrency("Namibian Dollar");

        rateList.get(106).setImageId(R.drawable.ngn_nigeria);
        rateList.get(106).setCountry("Nigeria");
        rateList.get(106).setCurrency("Nigerian Naira");

        rateList.get(107).setImageId(R.drawable.nio_nicaragua);
        rateList.get(107).setCountry("Nicaragua");
        rateList.get(107).setCurrency("Nicaraguan Cordoba");

        rateList.get(108).setImageId(R.drawable.nok_norway);
        rateList.get(108).setCountry("Norway");
        rateList.get(108).setCurrency("Norwegian Krone");

        rateList.get(109).setImageId(R.drawable.npr_nepal);
        rateList.get(109).setCountry("Nepal");
        rateList.get(109).setCurrency("Nepalese Rupee");

        rateList.get(110).setImageId(R.drawable.nzd_new_zealand);
        rateList.get(110).setCountry("New Zealand, Cook Islands, Niue, Pitcairn Island");
        rateList.get(110).setCurrency("New Zealand Dollar");

        rateList.get(111).setImageId(R.drawable.omr_oman);
        rateList.get(111).setCountry("Oman");
        rateList.get(111).setCurrency("Omani Rial");

        rateList.get(112).setImageId(R.drawable.pab_panama);
        rateList.get(112).setCountry("Panama");
        rateList.get(112).setCurrency("Balboa");

        rateList.get(113).setImageId(R.drawable.pen_peru);
        rateList.get(113).setCountry("Peru");
        rateList.get(113).setCurrency("Nuevo Sol");

        rateList.get(114).setImageId(R.drawable.pgk_papua_new_guinea);
        rateList.get(114).setCountry("Papua New Guinea");
        rateList.get(114).setCurrency("Kina");

        rateList.get(115).setImageId(R.drawable.php_philippines);
        rateList.get(115).setCountry("Philippines");
        rateList.get(115).setCurrency("Philippine Peso");

        rateList.get(116).setImageId(R.drawable.pkr_pakistan);
        rateList.get(116).setCountry("Pakistan");
        rateList.get(116).setCurrency("Pakistan Rupee");

        rateList.get(117).setImageId(R.drawable.pln_poland);
        rateList.get(117).setCountry("Poland");
        rateList.get(117).setCurrency("Zloty");

        rateList.get(118).setImageId(R.drawable.pyg_paraguay);
        rateList.get(118).setCountry("Paraguay");
        rateList.get(118).setCurrency("Guarani");

        rateList.get(119).setImageId(R.drawable.qar_qatar);
        rateList.get(119).setCountry("Qatar");
        rateList.get(119).setCurrency("Qatari Rial");

        rateList.get(120).setImageId(R.drawable.ron_romania);
        rateList.get(120).setCountry("Romania");
        rateList.get(120).setCurrency("Leu");

        rateList.get(121).setImageId(R.drawable.rsd_serbia);
        rateList.get(121).setCountry("Serbia, Kosovo");
        rateList.get(121).setCurrency("Serbian Dinar");

        rateList.get(122).setImageId(R.drawable.rub_russia);
        rateList.get(122).setCountry("Russia, South Ossetia");
        rateList.get(122).setCurrency("Russian Ruble");

        rateList.get(123).setImageId(R.drawable.rwf_rwanda);
        rateList.get(123).setCountry("Rwanda");
        rateList.get(123).setCurrency("Rwanda Franc");

        rateList.get(124).setImageId(R.drawable.sar_saudi_arabia);
        rateList.get(124).setCountry("Saudi Arabia");
        rateList.get(124).setCurrency("Saudi Riyal");

        rateList.get(125).setImageId(R.drawable.sbd_solomon_islands);
        rateList.get(125).setCountry("Solomon Islands");
        rateList.get(125).setCurrency("Solomon Islands Dollar");

        rateList.get(126).setImageId(R.drawable.scr_seychelles);
        rateList.get(126).setCountry("Seychelles");
        rateList.get(126).setCurrency("Seychelles Rupee");

        rateList.get(127).setImageId(R.drawable.sdg_sudan);
        rateList.get(127).setCountry("Sudan");
        rateList.get(127).setCurrency("Sudanese Pound");

        rateList.get(128).setImageId(R.drawable.sek_sweden);
        rateList.get(128).setCountry("Sweden");
        rateList.get(128).setCurrency("Swedish Krona");

        rateList.get(129).setImageId(R.drawable.sgd_singapore);
        rateList.get(129).setCountry("Singapore");
        rateList.get(129).setCurrency("Singapore Dollar");

        //rateList.get(130).setImageId(R.drawable.); No flag
        rateList.get(130).setCountry("Saint Helena, Ascension Island, Tristan da Cunha");
        rateList.get(130).setCurrency("Saint Helena Pound");

        rateList.get(131).setImageId(R.drawable.sll_sierra_leone);
        rateList.get(131).setCountry("Sierra Leone");
        rateList.get(131).setCurrency("Leone");

        rateList.get(132).setImageId(R.drawable.sos_somalia);
        rateList.get(132).setCountry("Somalia");
        rateList.get(132).setCurrency("Somali Shilling");

        rateList.get(133).setImageId(R.drawable.srd_suriname);
        rateList.get(133).setCountry("Suriname");
        rateList.get(133).setCurrency("Suriname Dollar");

        rateList.get(134).setImageId(R.drawable.std_sao_tome_and_prince);
        rateList.get(134).setCountry("Sao Tome and Prince");
        rateList.get(134).setCurrency("Dobra");

        rateList.get(135).setImageId(R.drawable.svc_el_salvador);
        rateList.get(135).setCountry("El Salvador");
        rateList.get(135).setCurrency("Salvadoran Colón");

        rateList.get(136).setImageId(R.drawable.syp_syria);
        rateList.get(136).setCountry("Syria");
        rateList.get(136).setCurrency("Syrian Pound");

        rateList.get(137).setImageId(R.drawable.szl_swaziland);
        rateList.get(137).setCountry("Swaziland");
        rateList.get(137).setCurrency("Lilangeni");

        rateList.get(138).setImageId(R.drawable.thb_thailand);
        rateList.get(138).setCountry("Thailand");
        rateList.get(138).setCurrency("Baht");

        rateList.get(139).setImageId(R.drawable.tjs_tajikistan);
        rateList.get(139).setCountry("Tajikistan");
        rateList.get(139).setCurrency("Somoni");

        rateList.get(140).setImageId(R.drawable.tmt_turkmenistan);
        rateList.get(140).setCountry("Turkmenistan");
        rateList.get(140).setCurrency("Manat");

        rateList.get(141).setImageId(R.drawable.tnd_tunisia);
        rateList.get(141).setCountry("Tunisia");
        rateList.get(141).setCurrency("Tunisian Dinar");

        rateList.get(142).setImageId(R.drawable.top_tonga);
        rateList.get(142).setCountry("Tonga");
        rateList.get(142).setCurrency("Pa’anga");

        rateList.get(143).setImageId(R.drawable.try_turkey);
        rateList.get(143).setCountry("Turkey, North Cyprus");
        rateList.get(143).setCurrency("Turkish Lira");

        rateList.get(144).setImageId(R.drawable.ttd_trinidad_and_tobago);
        rateList.get(144).setCountry("Trinidad and Tobago");
        rateList.get(144).setCurrency("Trinidad and Tobago Dollar");

        rateList.get(145).setImageId(R.drawable.twd_taiwan);
        rateList.get(145).setCountry("Taiwan");
        rateList.get(145).setCurrency("Taiwan Dollar");

        rateList.get(146).setImageId(R.drawable.tzs_tanzania);
        rateList.get(146).setCountry("Tanzania");
        rateList.get(146).setCurrency("Tanzanian Shilling");

        rateList.get(147).setImageId(R.drawable.uah_ukraine);
        rateList.get(147).setCountry("Ukraine");
        rateList.get(147).setCurrency("Hryvnia");

        rateList.get(148).setImageId(R.drawable.ugx_uganda);
        rateList.get(148).setCountry("Uganda");
        rateList.get(148).setCurrency("Uganda Shilling");

        rateList.get(149).setImageId(R.drawable.usd_united_states);
        rateList.get(149).setCountry("United States of America, American Samoa, British Indian Ocean Territory, " +
                "British Virgin Islands, Guam, Haiti, Marshall Islands, Micronesia, " +
                "Northern Mariana Islands, Pacific Remote islands, Palau, nPanama, " +
                "Puerto Rico, Turks and Caicos Islands, US Virgin Islands");
        rateList.get(149).setCurrency("US Dollar");

        rateList.get(150).setImageId(R.drawable.uyu_uruguay);
        rateList.get(150).setCountry("Uruguay");
        rateList.get(150).setCurrency("Peso Uruguayo");

        rateList.get(151).setImageId(R.drawable.uzs_uzbekistn);
        rateList.get(151).setCountry("Uzbekistn");
        rateList.get(151).setCurrency("Uzbekistan Sum");

        rateList.get(152).setImageId(R.drawable.vef_venezuela);
        rateList.get(152).setCountry("Venezuela");
        rateList.get(152).setCurrency("Bolivar Fuerte");

        rateList.get(153).setImageId(R.drawable.vnd_vietnam);
        rateList.get(153).setCountry("Vietnam");
        rateList.get(153).setCurrency("Dong");

        rateList.get(154).setImageId(R.drawable.vuv_vanuatu);
        rateList.get(154).setCountry("Vanuatu");
        rateList.get(154).setCurrency("Vatu");

        rateList.get(155).setImageId(R.drawable.wst_samoa);
        rateList.get(155).setCountry("Samoa");
        rateList.get(155).setCurrency("Tala");

        rateList.get(156).setImageId(R.drawable.xaf_cameroon);
        rateList.get(156).setCountry("Benin, Burkina Faso, Cameroon, Central African Republic, " +
                "Chad, Congo (Brazzaville), Côte d'Ivoire, Equatorial Guinea, Gabon, Guinea-Bissau, " +
                "Mali, Niger, Senegal, Togo");
        rateList.get(156).setCurrency("CFA Franc BCEAO");

        //rateList.get(157).setImageId(R.drawable.); (Not relate to country like bitcon)
        rateList.get(157).setCountry("Worldwide");
        rateList.get(157).setCurrency("Silver Ounce");

        //rateList.get(158).setImageId(R.drawable.); Not relate to country like bitcon)
        rateList.get(158).setCountry("Worldwide");
        rateList.get(158).setCurrency("Gold Ounce ");

        rateList.get(159).setImageId(R.drawable.xcd_saint_kitts_and_nevis);
        rateList.get(159).setCountry("Anguilla, Antigua and Barbuda, Dominica, Grenada, " +
                "Montserrat, Saint Kitts and Nevis, Saint Lucia, Saint Vincent and Grenadine");
        rateList.get(159).setCurrency("East Caribbean Dollar");

        //rateList.get(160).setImageId(R.drawable.); (International Monetary Fund)
        rateList.get(160).setCountry("WorldWide");
        rateList.get(160).setCurrency("IMF Special Drawing Rights");

        //rateList.get(161).setImageId(R.drawable.); (Communauté Financière Africaine (BCEAO))
        rateList.get(161).setCountry("WorldWide");
        rateList.get(161).setCurrency("CFA Franc");

        //rateList.get(162).setImageId(R.drawable.wst_samoa); (MultiCounty)
        rateList.get(162).setCountry("French Polynesia, New Caledonia, Wallis and Futuna");
        rateList.get(162).setCurrency("CFP Franc");

        rateList.get(163).setImageId(R.drawable.yer_yemen);
        rateList.get(163).setCountry("Yemen");
        rateList.get(163).setCurrency("Yemeni Rial");

        rateList.get(164).setImageId(R.drawable.zar_south_africa);
        rateList.get(164).setCountry("South Africa, Lesotho, Namibia");
        rateList.get(164).setCurrency("Rand");

        rateList.get(165).setImageId(R.drawable.zmw_zambia);
        rateList.get(165).setCountry("Zambia");
        rateList.get(165).setCurrency("Zambian Kwacha");

        rateList.get(166).setImageId(R.drawable.zmw_zambia);
        rateList.get(166).setCountry("Zambia");
        rateList.get(166).setCurrency("Zambian Kwacha");

        rateList.get(167).setImageId(R.drawable.zwl_zimbabwe);
        rateList.get(167).setCountry("Zimbabwe");
        rateList.get(167).setCurrency("Zimbabwe Dollar");
    }
}
