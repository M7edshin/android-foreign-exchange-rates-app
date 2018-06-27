package shahin.euexchange.utilities;

import java.util.List;

import shahin.euexchange.BuildConfig;
import shahin.euexchange.R;
import shahin.euexchange.models.Rates;

public class Constants {

    //Fixer Client API
    public static final String BASE_URL = "http://data.fixer.io/api/latest";
    public static final String API_ACCESS_KEY = BuildConfig.API_ACCESS_KEY;
    public static final String PAR_ACCESS_KEY = "access_key";

    //Fabian Country API
    public static final String COUNTRY_BASE_URL = "http://countryapi.gear.host/";

    //RateActivity
    public static final int LOADER_ID = 1;

    //Country & Details Activity
    public static final String INTENT_COUNTRY_KEY = "country_key";

    //Widget
    public static final String WIDGET_SHARED_PREFS_KEY = "shared_pref_key";

    public static void setAdditionalContent(List<Rates> ratesList){
        ratesList.get(0).setImageId(R.drawable.aed_united_arab_emirates);
        ratesList.get(0).setCountry("United Arab Emirates");
        ratesList.get(0).setCurrency("Emirati Dirham");

        ratesList.get(1).setImageId(R.drawable.afn_afghanistan);
        ratesList.get(1).setCountry("Afghanistan");
        ratesList.get(1).setCurrency("Afghan Afghani");

        ratesList.get(2).setImageId(R.drawable.all_albania);
        ratesList.get(2).setCountry("Albania");
        ratesList.get(2).setCurrency("Albanian Lek");

        ratesList.get(3).setImageId(R.drawable.amd_armenia);
        ratesList.get(3).setCountry("Armenia");
        ratesList.get(3).setCurrency("Armenian Dram");

        ratesList.get(4).setImageId(R.drawable.ang_netherlands);
        ratesList.get(4).setCountry("Netherlands");
        ratesList.get(4).setCurrency("Dutch Guilder");

        ratesList.get(5).setImageId(R.drawable.aoa_angola);
        ratesList.get(5).setCountry("Angola");
        ratesList.get(5).setCurrency("Angolan Kwanza");

        ratesList.get(6).setImageId(R.drawable.ars_argentina);
        ratesList.get(6).setCountry("Argentina");
        ratesList.get(6).setCurrency("Argentine Peso");

        ratesList.get(7).setImageId(R.drawable.aud_australia);
        ratesList.get(7).setCountry("Australia, Kiribati, Coconut Islands, Nauru, Tuvalu");
        ratesList.get(7).setCurrency("Australian Dollar");

        ratesList.get(8).setImageId(R.drawable.awg_aruba);
        ratesList.get(8).setCountry("Aruba");
        ratesList.get(8).setCurrency("Aruban florin");

        ratesList.get(9).setImageId(R.drawable.azn_azerbaijan);
        ratesList.get(9).setCountry("Azerbaijan");
        ratesList.get(9).setCurrency("Azerbaijani manat");

        ratesList.get(10).setImageId(R.drawable.bam_bosnia_and_herzegovina);
        ratesList.get(10).setCountry("Bosnia and Herzegovina");
        ratesList.get(10).setCurrency("Bosnian Convertible Marka");

        ratesList.get(11).setImageId(R.drawable.bbd_barbados);
        ratesList.get(11).setCountry("Barbados");
        ratesList.get(11).setCurrency("Barbadian or Bajan Dollar");

        ratesList.get(12).setImageId(R.drawable.bdt_bangladesh);
        ratesList.get(12).setCountry("Bbangladesh");
        ratesList.get(12).setCurrency("Bangladeshi taka");

        ratesList.get(13).setImageId(R.drawable.bgn_bulgaria);
        ratesList.get(13).setCountry("Bulgaria");
        ratesList.get(13).setCurrency("Bulgarian lev");

        ratesList.get(14).setImageId(R.drawable.bhd_bahrain);
        ratesList.get(14).setCountry("Bahrain");
        ratesList.get(14).setCurrency("Bahraini dinar");

        ratesList.get(15).setImageId(R.drawable.bif_burundi);
        ratesList.get(15).setCountry("Burundi");
        ratesList.get(15).setCurrency("Burundian franc");

        ratesList.get(16).setImageId(R.drawable.bmd_bermuda);
        ratesList.get(16).setCountry("Bermuda");
        ratesList.get(16).setCurrency("Bermudian dollar");

        ratesList.get(17).setImageId(R.drawable.bnd_brunei);
        ratesList.get(17).setCountry("Brunei, Singapore");
        ratesList.get(17).setCurrency("Brunei dollar");

        ratesList.get(18).setImageId(R.drawable.bob_bolivia);
        ratesList.get(18).setCountry("Bolivia");
        ratesList.get(18).setCurrency("Bolivian Bolíviano");

        ratesList.get(19).setImageId(R.drawable.brl_brazil);
        ratesList.get(19).setCountry("Brazil");
        ratesList.get(19).setCurrency("Brazilian real");

        ratesList.get(20).setImageId(R.drawable.bsd_bahamas);
        ratesList.get(20).setCountry("Bahamas");
        ratesList.get(20).setCurrency("Bahamian Dollar");

        //ratesList.get(21).setImageId(R.drawable.); >> Bitocn
        ratesList.get(21).setCountry("Virtual Currency (WorldWide)");
        ratesList.get(21).setCurrency("Bitcoin");

        ratesList.get(22).setImageId(R.drawable.btn_bhutan);
        ratesList.get(22).setCountry("Bhutan");
        ratesList.get(22).setCurrency("Bhutanese Ngultrum");

        ratesList.get(23).setImageId(R.drawable.bwp_botswana);
        ratesList.get(23).setCountry("Botswana");
        ratesList.get(23).setCurrency("Botswana pula");

        ratesList.get(24).setImageId(R.drawable.byn_belarus);
        ratesList.get(24).setCountry("Belarus");
        ratesList.get(24).setCurrency("Belarusian ruble");

        ratesList.get(25).setImageId(R.drawable.byn_belarus);
        ratesList.get(25).setCountry("Belarus");
        ratesList.get(25).setCurrency("Belarusian ruble");

        ratesList.get(26).setImageId(R.drawable.bzd_belize);
        ratesList.get(26).setCountry("Belize");
        ratesList.get(26).setCurrency("Belize dollar");

        ratesList.get(27).setImageId(R.drawable.cad_canada);
        ratesList.get(27).setCountry("Canada");
        ratesList.get(27).setCurrency("Canadian Dollar");

        ratesList.get(28).setImageId(R.drawable.cdf_democratic_republic_of_congo);
        ratesList.get(28).setCountry("Democratic Republic of Congo");
        ratesList.get(28).setCurrency("Congolese Franc");

        ratesList.get(29).setImageId(R.drawable.chf_switzerland);
        ratesList.get(29).setCountry("Switzerland, Lichtenstein");
        ratesList.get(29).setCurrency("Swiss Franc");

        ratesList.get(30).setImageId(R.drawable.clf_chile);
        ratesList.get(30).setCountry("Chile");
        ratesList.get(30).setCurrency("Chilean Unidad de Fomento");

        ratesList.get(31).setImageId(R.drawable.clf_chile);
        ratesList.get(31).setCountry("Chile");
        ratesList.get(31).setCurrency("Chilean Peso");

        ratesList.get(32).setImageId(R.drawable.cny_china);
        ratesList.get(32).setCountry("China");
        ratesList.get(32).setCurrency("Chinese Yuan");

        ratesList.get(33).setImageId(R.drawable.cop_colombia);
        ratesList.get(33).setCountry("Colombia");
        ratesList.get(33).setCurrency("Colombian Peso");

        ratesList.get(34).setImageId(R.drawable.crc_costa_rica);
        ratesList.get(34).setCountry("Costa Rica");
        ratesList.get(34).setCurrency("Costa Rican Colon");

        ratesList.get(35).setImageId(R.drawable.cuc_cuba);
        ratesList.get(35).setCountry("Cuba");
        ratesList.get(35).setCurrency("Cuban Convertible Peso");

        ratesList.get(36).setImageId(R.drawable.cuc_cuba);
        ratesList.get(36).setCountry("Cuba");
        ratesList.get(36).setCurrency("Cuban Peso");

        ratesList.get(37).setImageId(R.drawable.cve_cape_verde);
        ratesList.get(37).setCountry("Cape Verde");
        ratesList.get(37).setCurrency("Cape Verdean Escudo");

        ratesList.get(38).setImageId(R.drawable.czk_czech_republic);
        ratesList.get(38).setCountry("Czechia");
        ratesList.get(38).setCurrency("Czech koruna");

        ratesList.get(39).setImageId(R.drawable.djf_djibouti);
        ratesList.get(39).setCountry("Djibouti");
        ratesList.get(39).setCurrency("Djiboutian Franc");

        ratesList.get(40).setImageId(R.drawable.dkk_denmark);
        ratesList.get(40).setCountry("Denmark");
        ratesList.get(40).setCurrency("Danish Krone");

        ratesList.get(41).setImageId(R.drawable.dop_dominican_republic);
        ratesList.get(41).setCountry("Dominican Republic");
        ratesList.get(41).setCurrency("Dominican Peso");

        ratesList.get(42).setImageId(R.drawable.dzd_algeria);
        ratesList.get(42).setCountry("Algeria");
        ratesList.get(42).setCurrency("Algerian Dinar");

        ratesList.get(43).setImageId(R.drawable.egp_egypt);
        ratesList.get(43).setCountry("Egypt");
        ratesList.get(43).setCurrency("Egyptian pound");

        ratesList.get(44).setImageId(R.drawable.ern_eritrea);
        ratesList.get(44).setCountry("Eritrea");
        ratesList.get(44).setCurrency("Eritrean Nakfa");

        ratesList.get(45).setImageId(R.drawable.etb_ethiopia);
        ratesList.get(45).setCountry("Ethiopia");
        ratesList.get(45).setCurrency("Ethiopian Birr");

        //ratesList.get(21).setImageId(R.drawable.); >> EURO
        ratesList.get(46).setCountry("Akrotiri and Dhekelia, Andorra, Austria, Belgium, Cyprus, " +
                "Estonia, Finland, France, Germany, Greece, Ireland, Italy, Kosovo, Latvia, Lithuania" +
                "Luxembourg, Malta, Monaco, Montenegro, Netherlands, Portugal, San-Marino, Slovakia" +
                "Slovenia, Spain, Vatican");
        ratesList.get(46).setCurrency("Euro");

        ratesList.get(47).setImageId(R.drawable.fjd_fiji);
        ratesList.get(47).setCountry("Fiji");
        ratesList.get(47).setCurrency("Fijian dollar");

        ratesList.get(48).setImageId(R.drawable.fkp_falkland_islands);
        ratesList.get(48).setCountry("Falkland Island");
        ratesList.get(48).setCurrency("Falkland Island Pound");


        ratesList.get(49).setImageId(R.drawable.gbp_england);
        ratesList.get(49).setCountry("England");
        ratesList.get(49).setCurrency("Sterling");

        ratesList.get(50).setImageId(R.drawable.gel_georgia);
        ratesList.get(50).setCountry("Georgia");
        ratesList.get(50).setCurrency("Georgian Lari");

        ratesList.get(51).setImageId(R.drawable.ggp_guernsey);
        ratesList.get(51).setCountry("Guernsey");
        ratesList.get(51).setCurrency("Guernsey Pound");

        ratesList.get(52).setImageId(R.drawable.ghs_ghana);
        ratesList.get(52).setCountry("Ghana");
        ratesList.get(52).setCurrency("Ghanaian Cedi");

        ratesList.get(53).setImageId(R.drawable.gip_gibraltar);
        ratesList.get(53).setCountry("Gibraltar");
        ratesList.get(53).setCurrency("Gibraltar pound");

        ratesList.get(54).setImageId(R.drawable.gmd_gambia);
        ratesList.get(54).setCountry("Gambia");
        ratesList.get(54).setCurrency("Gambian Dalasi");

        ratesList.get(55).setImageId(R.drawable.gnf_guinea);
        ratesList.get(55).setCountry("Guinea");
        ratesList.get(55).setCurrency("Guinean franc");

        ratesList.get(56).setImageId(R.drawable.gtq_guatemala);
        ratesList.get(56).setCountry("Guatemala");
        ratesList.get(56).setCurrency("Guatemalan Quetzal");

        //ratesList.get(57).setImageId(R.drawable.); No flag
        ratesList.get(57).setCountry("British Guiana");
        ratesList.get(57).setCurrency("Guyanaese Dollar");

        ratesList.get(58).setImageId(R.drawable.hkd_hong_kong);
        ratesList.get(58).setCountry("Hong Kong");
        ratesList.get(58).setCurrency("Hong Kong Dollar");

        ratesList.get(59).setImageId(R.drawable.hnl_honduras);
        ratesList.get(59).setCountry("Honduras");
        ratesList.get(59).setCurrency("Honduran Lempira");

        ratesList.get(60).setImageId(R.drawable.hrk_croatia);
        ratesList.get(60).setCountry("Croatia");
        ratesList.get(60).setCurrency("Croatian Kuna");

        ratesList.get(61).setImageId(R.drawable.htg_haiti);
        ratesList.get(61).setCountry("Haiti");
        ratesList.get(61).setCurrency("Haitian Gourde");

        ratesList.get(62).setImageId(R.drawable.huf_hungary);
        ratesList.get(62).setCountry("Hungary");
        ratesList.get(62).setCurrency("Hungarian Forint");

        ratesList.get(63).setImageId(R.drawable.idr_indonesia);
        ratesList.get(63).setCountry("Indonesia");
        ratesList.get(63).setCurrency("Indonesian Rupiah");

        //Israel Delete it
        //ratesList.get(64).setImageId(R.drawable.);
        //ratesList.get(64).setCountry(" ");
        //ratesList.get(64).setCurrency(" ");

        ratesList.get(65).setImageId(R.drawable.imp_isle_of_man);
        ratesList.get(65).setCountry("Isle of man");
        ratesList.get(65).setCurrency("Isle of Man Pound");

        ratesList.get(66).setImageId(R.drawable.inr_india);
        ratesList.get(66).setCountry("India");
        ratesList.get(66).setCurrency("Indian rupee");

        ratesList.get(67).setImageId(R.drawable.iqd_iraq);
        ratesList.get(67).setCountry("Iraq");
        ratesList.get(67).setCurrency("Iraqi Dinar");

        ratesList.get(68).setImageId(R.drawable.irr_iran);
        ratesList.get(68).setCountry("Iran");
        ratesList.get(68).setCurrency("Iranian Rial");

        ratesList.get(69).setImageId(R.drawable.isk_iceland);
        ratesList.get(69).setCountry("Iceland");
        ratesList.get(69).setCurrency("Icelandic Krona");

        ratesList.get(70).setImageId(R.drawable.jep_jersey);
        ratesList.get(70).setCountry("Jersey");
        ratesList.get(70).setCurrency("Jersey Pound");

        ratesList.get(71).setImageId(R.drawable.jmd_jamaica);
        ratesList.get(71).setCountry("Jamaica");
        ratesList.get(71).setCurrency("Jamaican Dollar");

        ratesList.get(72).setImageId(R.drawable.jod_jordan);
        ratesList.get(72).setCountry("Jordan");
        ratesList.get(72).setCurrency("Jordanian Dinar");

        ratesList.get(73).setImageId(R.drawable.jpy_japan);
        ratesList.get(73).setCountry("Japan");
        ratesList.get(73).setCurrency("Japanese Yen");

        //________________________________________________________


        ratesList.get(74).setImageId(R.drawable.kes_kenya);
        ratesList.get(74).setCountry("Kenya");
        ratesList.get(74).setCurrency("Kenyan Shilling");

        ratesList.get(75).setImageId(R.drawable.kgs_kyrgyzstan);
        ratesList.get(75).setCountry("Kyrgyzstan");
        ratesList.get(75).setCurrency("Kyrgyzstani Som");

        ratesList.get(76).setImageId(R.drawable.khr_cambodia);
        ratesList.get(76).setCountry("Cambodia");
        ratesList.get(76).setCurrency("Cambodian Riel");

        ratesList.get(77).setImageId(R.drawable.kmf_comoros);
        ratesList.get(77).setCountry("Comoros");
        ratesList.get(77).setCurrency("Comorian Franc");

        ratesList.get(78).setImageId(R.drawable.kpw_northkorea);
        ratesList.get(78).setCountry("North Korea");
        ratesList.get(78).setCurrency("North Korean Won");

        ratesList.get(79).setImageId(R.drawable.krw_southkorea);
        ratesList.get(79).setCountry("South Korea");
        ratesList.get(79).setCurrency("South Korean Won");

        ratesList.get(80).setImageId(R.drawable.kwd_kwait);
        ratesList.get(80).setCountry("Kuwait");
        ratesList.get(80).setCurrency("Kuwaiti Dinar");

        ratesList.get(81).setImageId(R.drawable.kyd_caymanislands);
        ratesList.get(81).setCountry("Caymanislands");
        ratesList.get(81).setCurrency("Caymanian Dollar");

        ratesList.get(82).setImageId(R.drawable.kzt_kazakhstan);
        ratesList.get(82).setCountry("Kazakhstan");
        ratesList.get(82).setCurrency("Kazakhstani Tenge");

        ratesList.get(83).setImageId(R.drawable.lak_laos);
        ratesList.get(83).setCountry("Laos");
        ratesList.get(83).setCurrency("Lao Kip");

        ratesList.get(84).setImageId(R.drawable.lbp_lebanon);
        ratesList.get(84).setCountry("Lebanon");
        ratesList.get(84).setCurrency("Lebanese pound");

        ratesList.get(85).setImageId(R.drawable.lkr_srilanka);
        ratesList.get(85).setCountry("Sri lanka");
        ratesList.get(85).setCurrency("Sri Lankan Rupee");

        ratesList.get(86).setImageId(R.drawable.lrd_liberia);
        ratesList.get(86).setCountry("Liberia");
        ratesList.get(86).setCurrency("Liberian Dollar");

        ratesList.get(87).setImageId(R.drawable.lsl_lesotho);
        ratesList.get(87).setCountry("Lesotho");
        ratesList.get(87).setCurrency("Lesotho Loti");

        ratesList.get(88).setImageId(R.drawable.ltl_lithuania);
        ratesList.get(88).setCountry("Lithuania");
        ratesList.get(88).setCurrency("Lithuanian Litas");

        ratesList.get(89).setImageId(R.drawable.lvl_latvia);
        ratesList.get(89).setCountry("Latvia");
        ratesList.get(89).setCurrency("Lithuanian Litas");

        ratesList.get(90).setImageId(R.drawable.lyd_libya);
        ratesList.get(90).setCountry("Libya");
        ratesList.get(90).setCurrency("Libyan Dinar");

        ratesList.get(91).setImageId(R.drawable.mad_morocco);
        ratesList.get(91).setCountry("Morocco");
        ratesList.get(91).setCurrency("Moroccan Dirham");

        ratesList.get(92).setImageId(R.drawable.mdl_moldova);
        ratesList.get(92).setCountry("Moldova");
        ratesList.get(92).setCurrency("Moldovan Leu");

        ratesList.get(93).setImageId(R.drawable.mga_madagascar);
        ratesList.get(93).setCountry("Madagascar");
        ratesList.get(93).setCurrency("Malagasy Ariary");

        ratesList.get(94).setImageId(R.drawable.mkd_republic_of_macedonia);
        ratesList.get(94).setCountry("Republic of Macedonia");
        ratesList.get(94).setCurrency("Macedonian Denar");

        ratesList.get(95).setImageId(R.drawable.mmk_myanmar);
        ratesList.get(95).setCountry("Myanmar");
        ratesList.get(95).setCurrency("Burmese Kyat");

        ratesList.get(96).setImageId(R.drawable.mnt_mongolia);
        ratesList.get(96).setCountry("Mongolia");
        ratesList.get(96).setCurrency("Mongolian Tughrik");

        ratesList.get(97).setImageId(R.drawable.mop_macau);
        ratesList.get(97).setCountry("Macau");
        ratesList.get(97).setCurrency("Macau Pataca");

        ratesList.get(98).setImageId(R.drawable.mro_mauritania);
        ratesList.get(98).setCountry("Mauritania");
        ratesList.get(98).setCurrency("Mauritanian Ouguiya");

        ratesList.get(99).setImageId(R.drawable.mur_mauritius);
        ratesList.get(99).setCountry("Mauritius");
        ratesList.get(99).setCurrency("Mauritian Rupee");

        ratesList.get(100).setImageId(R.drawable.mvr_maldives);
        ratesList.get(100).setCountry("Maldives");
        ratesList.get(100).setCurrency("Maldivian Rufiyaa");

        ratesList.get(101).setImageId(R.drawable.mwk_malawi);
        ratesList.get(101).setCountry("Malawi");
        ratesList.get(101).setCurrency("Malawian Kwacha");

        ratesList.get(102).setImageId(R.drawable.mxn_mexico);
        ratesList.get(102).setCountry("Mexico");
        ratesList.get(102).setCurrency("Mexican peso");

        ratesList.get(103).setImageId(R.drawable.myr_malasya);
        ratesList.get(103).setCountry("Malasya");
        ratesList.get(103).setCurrency("Malaysian Ringgit");

        ratesList.get(104).setImageId(R.drawable.mzn_mozambique);
        ratesList.get(104).setCountry("Mozambique");
        ratesList.get(104).setCurrency("Mozambican metical");

        ratesList.get(105).setImageId(R.drawable.nad_namibia);
        ratesList.get(105).setCountry("Namibia");
        ratesList.get(105).setCurrency("Namibian Dollar");

        ratesList.get(106).setImageId(R.drawable.ngn_nigeria);
        ratesList.get(106).setCountry("Nigeria");
        ratesList.get(106).setCurrency("Nigerian Naira");

        ratesList.get(107).setImageId(R.drawable.nio_nicaragua);
        ratesList.get(107).setCountry("Nicaragua");
        ratesList.get(107).setCurrency("Nicaraguan Cordoba");

        ratesList.get(108).setImageId(R.drawable.nok_norway);
        ratesList.get(108).setCountry("Norway");
        ratesList.get(108).setCurrency("Norwegian Krone");

        ratesList.get(109).setImageId(R.drawable.npr_nepal);
        ratesList.get(109).setCountry("Nepal");
        ratesList.get(109).setCurrency("Nepalese Rupee");

        ratesList.get(110).setImageId(R.drawable.nzd_new_zealand);
        ratesList.get(110).setCountry("New Zealand, Cook Islands, Niue, Pitcairn Island");
        ratesList.get(110).setCurrency("New Zealand Dollar");

        ratesList.get(111).setImageId(R.drawable.omr_oman);
        ratesList.get(111).setCountry("Oman");
        ratesList.get(111).setCurrency("Omani Rial");

        ratesList.get(112).setImageId(R.drawable.pab_panama);
        ratesList.get(112).setCountry("Panama");
        ratesList.get(112).setCurrency("Balboa");

        ratesList.get(113).setImageId(R.drawable.pen_peru);
        ratesList.get(113).setCountry("Peru");
        ratesList.get(113).setCurrency("Nuevo Sol");

        ratesList.get(114).setImageId(R.drawable.pgk_papua_new_guinea);
        ratesList.get(114).setCountry("Papua New Guinea");
        ratesList.get(114).setCurrency("Kina");

        ratesList.get(115).setImageId(R.drawable.php_philippines);
        ratesList.get(115).setCountry("Philippines");
        ratesList.get(115).setCurrency("Philippine Peso");

        ratesList.get(116).setImageId(R.drawable.pkr_pakistan);
        ratesList.get(116).setCountry("Pakistan");
        ratesList.get(116).setCurrency("Pakistan Rupee");

        ratesList.get(117).setImageId(R.drawable.pln_poland);
        ratesList.get(117).setCountry("Poland");
        ratesList.get(117).setCurrency("Zloty");

        ratesList.get(118).setImageId(R.drawable.pyg_paraguay);
        ratesList.get(118).setCountry("Paraguay");
        ratesList.get(118).setCurrency("Guarani");

        ratesList.get(119).setImageId(R.drawable.qar_qatar);
        ratesList.get(119).setCountry("Qatar");
        ratesList.get(119).setCurrency("Qatari Rial");

        ratesList.get(120).setImageId(R.drawable.ron_romania);
        ratesList.get(120).setCountry("Romania");
        ratesList.get(120).setCurrency("Leu");

        ratesList.get(121).setImageId(R.drawable.rsd_serbia);
        ratesList.get(121).setCountry("Serbia, Kosovo");
        ratesList.get(121).setCurrency("Serbian Dinar");

        ratesList.get(122).setImageId(R.drawable.rub_russia);
        ratesList.get(122).setCountry("Russia, South Ossetia");
        ratesList.get(122).setCurrency("Russian Ruble");

        ratesList.get(123).setImageId(R.drawable.rwf_rwanda);
        ratesList.get(123).setCountry("Rwanda");
        ratesList.get(123).setCurrency("Rwanda Franc");


        ratesList.get(124).setImageId(R.drawable.sar_saudi_arabia);
        ratesList.get(124).setCountry("Saudi Arabia");
        ratesList.get(124).setCurrency("Saudi Riyal");

        ratesList.get(125).setImageId(R.drawable.sbd_solomon_islands);
        ratesList.get(125).setCountry("Solomon Islands");
        ratesList.get(125).setCurrency("Solomon Islands Dollar");

        ratesList.get(126).setImageId(R.drawable.scr_seychelles);
        ratesList.get(126).setCountry("Seychelles");
        ratesList.get(126).setCurrency("Seychelles Rupee");

        ratesList.get(127).setImageId(R.drawable.sdg_sudan);
        ratesList.get(127).setCountry("Sudan");
        ratesList.get(127).setCurrency("Sudanese Pound");

        ratesList.get(128).setImageId(R.drawable.sek_sweden);
        ratesList.get(128).setCountry("Sweden");
        ratesList.get(128).setCurrency("Swedish Krona");

        ratesList.get(129).setImageId(R.drawable.sgd_singapore);
        ratesList.get(129).setCountry("Singapore");
        ratesList.get(129).setCurrency("Singapore Dollar");

        //ratesList.get(130).setImageId(R.drawable.); No flag
        ratesList.get(130).setCountry("Saint Helena, Ascension Island, Tristan da Cunha");
        ratesList.get(130).setCurrency("Saint Helena Pound");

        ratesList.get(131).setImageId(R.drawable.sll_sierra_leone);
        ratesList.get(131).setCountry("Sierra Leone");
        ratesList.get(131).setCurrency("Leone");

        ratesList.get(132).setImageId(R.drawable.sos_somalia);
        ratesList.get(132).setCountry("Somalia");
        ratesList.get(132).setCurrency("Somali Shilling");

        ratesList.get(133).setImageId(R.drawable.srd_suriname);
        ratesList.get(133).setCountry("Suriname");
        ratesList.get(133).setCurrency("Suriname Dollar");

        ratesList.get(134).setImageId(R.drawable.std_sao_tome_and_prince);
        ratesList.get(134).setCountry("Sao Tome and Prince");
        ratesList.get(134).setCurrency("Dobra");

        ratesList.get(135).setImageId(R.drawable.svc_el_salvador);
        ratesList.get(135).setCountry("El Salvador");
        ratesList.get(135).setCurrency("Salvadoran Colón");

        ratesList.get(136).setImageId(R.drawable.syp_syria);
        ratesList.get(136).setCountry("Syria");
        ratesList.get(136).setCurrency("Syrian Pound");

        ratesList.get(137).setImageId(R.drawable.szl_swaziland);
        ratesList.get(137).setCountry("Swaziland");
        ratesList.get(137).setCurrency("Lilangeni");

        ratesList.get(138).setImageId(R.drawable.thb_thailand);
        ratesList.get(138).setCountry("Thailand");
        ratesList.get(138).setCurrency("Baht");

        ratesList.get(139).setImageId(R.drawable.tjs_tajikistan);
        ratesList.get(139).setCountry("Tajikistan");
        ratesList.get(139).setCurrency("Somoni");

        ratesList.get(140).setImageId(R.drawable.tmt_turkmenistan);
        ratesList.get(140).setCountry("Turkmenistan");
        ratesList.get(140).setCurrency("Manat");

        ratesList.get(141).setImageId(R.drawable.tnd_tunisia);
        ratesList.get(141).setCountry("Tunisia");
        ratesList.get(141).setCurrency("Tunisian Dinar");

        ratesList.get(142).setImageId(R.drawable.top_tonga);
        ratesList.get(142).setCountry("Tonga");
        ratesList.get(142).setCurrency("Pa’anga");

        ratesList.get(143).setImageId(R.drawable.try_turkey);
        ratesList.get(143).setCountry("Turkey, North Cyprus");
        ratesList.get(143).setCurrency("Turkish Lira");

        ratesList.get(144).setImageId(R.drawable.ttd_trinidad_and_tobago);
        ratesList.get(144).setCountry("Trinidad and Tobago");
        ratesList.get(144).setCurrency("Trinidad and Tobago Dollar");

        ratesList.get(145).setImageId(R.drawable.twd_taiwan);
        ratesList.get(145).setCountry("Taiwan");
        ratesList.get(145).setCurrency("Taiwan Dollar");

        ratesList.get(146).setImageId(R.drawable.tzs_tanzania);
        ratesList.get(146).setCountry("Tanzania");
        ratesList.get(146).setCurrency("Tanzanian Shilling");

        ratesList.get(147).setImageId(R.drawable.uah_ukraine);
        ratesList.get(147).setCountry("Ukraine");
        ratesList.get(147).setCurrency("Hryvnia");

        ratesList.get(148).setImageId(R.drawable.ugx_uganda);
        ratesList.get(148).setCountry("Uganda");
        ratesList.get(148).setCurrency("Uganda Shilling");

        ratesList.get(149).setImageId(R.drawable.usd_united_states);
        ratesList.get(149).setCountry("United States of America, American Samoa, British Indian Ocean Territory, " +
                "British Virgin Islands, Guam, Haiti, Marshall Islands, Micronesia, " +
                "Northern Mariana Islands, Pacific Remote islands, Palau, nPanama, " +
                "Puerto Rico, Turks and Caicos Islands, US Virgin Islands");
        ratesList.get(149).setCurrency("US Dollar");

        ratesList.get(150).setImageId(R.drawable.uyu_uruguay);
        ratesList.get(150).setCountry("Uruguay");
        ratesList.get(150).setCurrency("Peso Uruguayo");

        ratesList.get(151).setImageId(R.drawable.uzs_uzbekistn);
        ratesList.get(151).setCountry("Uzbekistn");
        ratesList.get(151).setCurrency("Uzbekistan Sum");

        ratesList.get(152).setImageId(R.drawable.vef_venezuela);
        ratesList.get(152).setCountry("Venezuela");
        ratesList.get(152).setCurrency("Bolivar Fuerte");

        ratesList.get(153).setImageId(R.drawable.vnd_vietnam);
        ratesList.get(153).setCountry("Vietnam");
        ratesList.get(153).setCurrency("Dong");

        ratesList.get(154).setImageId(R.drawable.vuv_vanuatu);
        ratesList.get(154).setCountry("Vanuatu");
        ratesList.get(154).setCurrency("Vatu");

        ratesList.get(155).setImageId(R.drawable.wst_samoa);
        ratesList.get(155).setCountry("Samoa");
        ratesList.get(155).setCurrency("Tala");

        ratesList.get(156).setImageId(R.drawable.xaf_cameroon);
        ratesList.get(156).setCountry("Benin, Burkina Faso, Cameroon, Central African Republic, " +
                "Chad, Congo (Brazzaville), Côte d'Ivoire, Equatorial Guinea, Gabon, Guinea-Bissau, " +
                "Mali, Niger, Senegal, Togo");
        ratesList.get(156).setCurrency("CFA Franc BCEAO");

        //ratesList.get(157).setImageId(R.drawable.); (Not relate to country like bitcon)
        ratesList.get(157).setCountry("Worldwide");
        ratesList.get(157).setCurrency("Silver Ounce");

        //ratesList.get(158).setImageId(R.drawable.); Not relate to country like bitcon)
        ratesList.get(158).setCountry("Worldwide");
        ratesList.get(158).setCurrency("Gold Ounce ");

        ratesList.get(159).setImageId(R.drawable.xcd_saint_kitts_and_nevis);
        ratesList.get(159).setCountry("Anguilla, Antigua and Barbuda, Dominica, Grenada, " +
                "Montserrat, Saint Kitts and Nevis, Saint Lucia, Saint Vincent and Grenadine");
        ratesList.get(159).setCurrency("East Caribbean Dollar");

        //ratesList.get(160).setImageId(R.drawable.); (International Monetary Fund)
        ratesList.get(160).setCountry("WorldWide");
        ratesList.get(160).setCurrency("IMF Special Drawing Rights");

        //ratesList.get(161).setImageId(R.drawable.); (Communauté Financière Africaine (BCEAO))
        ratesList.get(161).setCountry("WorldWide");
        ratesList.get(161).setCurrency("CFA Franc");

        //ratesList.get(162).setImageId(R.drawable.wst_samoa); (MultiCounty)
        ratesList.get(162).setCountry("French Polynesia, New Caledonia, Wallis and Futuna");
        ratesList.get(162).setCurrency("CFP Franc");

        ratesList.get(163).setImageId(R.drawable.yer_yemen);
        ratesList.get(163).setCountry("Yemen");
        ratesList.get(163).setCurrency("Yemeni Rial");

        ratesList.get(164).setImageId(R.drawable.zar_south_africa);
        ratesList.get(164).setCountry("South Africa, Lesotho, Namibia");
        ratesList.get(164).setCurrency("Rand");

        ratesList.get(165).setImageId(R.drawable.zmw_zambia);
        ratesList.get(165).setCountry("Zambia");
        ratesList.get(165).setCurrency("Zambian Kwacha");

        ratesList.get(166).setImageId(R.drawable.zmw_zambia);
        ratesList.get(166).setCountry("Zambia");
        ratesList.get(166).setCurrency("Zambian Kwacha");

        ratesList.get(167).setImageId(R.drawable.zwl_zimbabwe);
        ratesList.get(167).setCountry("Zimbabwe");
        ratesList.get(167).setCurrency("Zimbabwe Dollar");
    }
}
