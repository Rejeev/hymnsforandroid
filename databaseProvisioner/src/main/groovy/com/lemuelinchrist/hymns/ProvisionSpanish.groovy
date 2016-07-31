package com.lemuelinchrist.hymns

import com.lemuelinchrist.hymns.lib.Dao
import com.lemuelinchrist.hymns.lib.beans.HymnsEntity

/**
 * Created by lcantos on 29/7/2016.
 */
class ProvisionSpanish {

    public static void main(String[] args) throws Exception {
//        Dao dao = new Dao();
//        HymnsEntity hymn;
        File file = new File(this.getClass().getResource("/spanish.txt").getPath());

//        for(String line: file.readLines()) {
//            println line;
//        }
        Iterator<String> iterator = file.iterator();
        Integer hymnNumber = 0;
        while (iterator.hasNext()) {
            String line = iterator.next().trim();
            if(line.isEmpty()) {
                line = iterator.next().trim();
                if (line.isEmpty()) {
                    hymnNumber++;
                    if (hymnNumber==501) break;
//                    println("searching for ${hymnNumber}")
                    line = iterator.next().trim();
                    if(!line.equals(hymnNumber+".")) {
                        throw new RuntimeException("Missing Hymn: " + hymnNumber);
                    }


                    println "Hymn ${hymnNumber} found!"


                } else if (line.toLowerCase().contains("coro:")) {
                    line = iterator.next().trim();
                    if (line.isEmpty()) throw new RuntimeException("blank line after chorus");
//                    if (line.isEmpty()) println("*****${hymnNumber}");

                } else if(!line[0].isInteger() && !line[0].equals('(') && !line[0].equals('+')) {
                    throw new RuntimeException("Invalid start of stanza");
                }

            }

        }

    }
}
