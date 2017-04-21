package com.joseph.services;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by joseph on 4/3/17.
 * Email: developergitch@outlook.com
 */

/**
 * This annotation acts as a decorator for all Service methods
 * Encapsulates the service in @repository managed by spring container
 * Also registers the class as a transactional so the transaction are managed
 * by default configured transaction manager
 */
@Target(value = ElementType.TYPE)
@Transactional(readOnly = true)
@Repository
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DefaultService {
}
