package com.test.jba.service;

import com.test.jba.entity.Item;
import com.test.jba.exception.RssException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.List;

@Service
public class RssServise {

    public List<Item> getItems() throws RssException {
        try {
            JAXBContext.newInstance(ObjectFactory.class);

        } catch (JAXBException e) {
           throw new RssException(e);
        }
    }

}
