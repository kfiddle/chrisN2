package com.example.demo;


import com.example.demo.junctionTables.PerformancePiece_Player;
import com.example.demo.junctionTables.PlayerPerformanceReply;
import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import com.example.demo.repositories.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PerformanceRepository performanceRepo;

    @MockBean
    private InstrumentRepository instrumentRepo;

    @MockBean
    private PlayerRepository playerRepo;

    @MockBean
    InstrumentPlayerRepository ipRepo;

    @MockBean
    PieceRepository pieceRepo;

    @MockBean
    private PerformancePieceRepository ppRepo;

    @MockBean
    private PerformancePiece_PlayerRepository pppRepo;

    @MockBean
    private PlayerPerformanceReplyRepository ppReplyRepo;

    @Test
    public void shouldBeAbleToAddPerformance() throws Exception {
        Performance testPerformance = new Performance("Show");
        String jsonVersion = new ObjectMapper().writeValueAsString(testPerformance);

        mockMvc.perform(post("/add-performance").content(jsonVersion).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());


    }
}









