/**
 * 
 * Copyright (c) 2013 On Center Software, Inc - All Rights Reserved
 *
 * SampleApiEntity.java 
 * 
 */
 


package net.foster.sample.rest;

//~--- non-JDK imports --------------------------------------------------------

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//~--- classes ----------------------------------------------------------------

/**
 * Sample Entity
 *
 *
 * @author         Daryl Foster    
 */
@ApiModel (
    value       = "SampleApiEntity",
    description = "This is a sample entity from the Api package."
)
@Entity
public class SampleApiEntity
        implements Serializable
{
    //~--- constructors -------------------------------------------------------

    /**
     * Constructs ...
     *
     */
    public SampleApiEntity () {}

    //~--- static fields ------------------------------------------------------

    private static final long serialVersionUID = 1L;

    //~--- fields -------------------------------------------------------------

    @Column (nullable = false)
    @ApiModelProperty (
        value    = "level",
        required = true
    )
    private Integer   level;
    @Column (length = 255)
    @ApiModelProperty (
        value    = "description",
        required = false
    )
    private String    description;
    @Column (nullable = false)
    @ApiModelProperty (
        value    = "time",
        required = true
    )
    private Timestamp time;
    @Id
    @Column (
        unique   = true,
        nullable = false
    )
    @Type (type = "pg-uuid")
    @ApiModelProperty (
        value    = "id",
        readOnly = true,
        example  = "123e4567-e89b-12d3-a456-426655440000"
    )
    private UUID      sampleApiEntityId;

    //~--- get methods --------------------------------------------------------

    /**
     * Method description
     *
     *
     * @return
     */
    public String getDescription ()
    {
        return this.description;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Integer getLevel ()
    {
        return this.level;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public UUID getSampleApiEntityId ()
    {
        return this.sampleApiEntityId;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Timestamp getTime ()
    {
        return this.time;
    }

    //~--- set methods --------------------------------------------------------

    /**
     * Method description
     *
     *
     * @param description
     */
    public void setDescription (String description)
    {
        this.description = description;
    }

    /**
     * Method description
     *
     *
     * @param level
     */
    public void setLevel (Integer level)
    {
        this.level = level;
    }

    /**
     * Method description
     *
     *
     * @param sampleApiEntityId
     */
    public void setSampleApiEntityId (UUID sampleApiEntityId)
    {
        this.sampleApiEntityId = sampleApiEntityId;
    }

    /**
     * Method description
     *
     *
     * @param time
     */
    public void setTime (Timestamp time)
    {
        this.time = time;
    }
}
